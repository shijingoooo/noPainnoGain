package com.founder.mediacloud.mam.commons;

import com.founder.e5.commons.DateUtils;
import com.founder.e5.commons.Log;
import com.founder.e5.context.Context;
import com.founder.e5.context.E5Exception;
import com.founder.mediacloud.mam.tv.DayOfTvPrograms;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Description: 读取Excel内容
 */
public class ExcelReader {

    private static Log logger = Context.getLog("mam");
    private static final String XLS = "xls";
    private static final String XLSX = "xlsx";

    /**
     * 根据文件后缀名类型获取对应的工作簿对象
     *
     * @param inputStream 读取文件的输入流
     * @param fileType    文件后缀名类型（xls或xlsx）
     * @return 包含文件数据的工作簿对象
     */
    public static Workbook getWorkbook(InputStream inputStream, String fileType) throws IOException {
        Workbook workbook = null;
        if (fileType.equalsIgnoreCase(XLS)) {
            workbook = new HSSFWorkbook(inputStream);
        } else if (fileType.equalsIgnoreCase(XLSX)) {
            workbook = new XSSFWorkbook(inputStream);
        }
        return workbook;
    }

    /**
     * 读取Excel文件内容
     *
     * @return 读取结果列表，读取失败时返回null
     */
    public static List<DayOfTvPrograms> readExcel(InputStream inputStream) throws E5Exception {

        try (Workbook workbook = getWorkbook(inputStream, "xls")) {

            // 读取excel中的数据
            return parseExcel(workbook);

        } catch (Exception e) {
            throw new E5Exception("解析节目单失败", e);
        }
    }

    /**
     * 解析Excel数据
     *
     * @param workbook Excel工作簿对象
     * @return 解析结果
     */
    private static List<DayOfTvPrograms> parseExcel(Workbook workbook) throws Exception {
        List<DayOfTvPrograms> programs = null;
        // 解析sheet
        for (int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
            Sheet sheet = workbook.getSheetAt(sheetNum);
            // 校验sheet是否合法
            if (sheet == null) {
                continue;
            }
            programs = programs(sheet);
        }
        return programs;
    }

    /**
     * 解析全部节目单
     */
    private static List<DayOfTvPrograms> programs(Sheet sheet) throws Exception {
        List<DayOfTvPrograms> data = new ArrayList<>(10);

        // 日期行，计算总天数（列）
        Row rowDate = sheet.getRow(2);

        // 从第三列开始
        int colStart = 3;
        // 最后一行
        int colEnd = rowDate.getPhysicalNumberOfCells();

        // 总行数
        int endRow = sheet.getPhysicalNumberOfRows();

        // 解析所有节目单
        for (int i = colStart; i < colEnd; i++) {
            data.add(oneDay(sheet, i, endRow));
        }

        return data;
    }

    /**
     * 解析一天的节目单
     */
    private static DayOfTvPrograms oneDay(Sheet sheet, int col, int endRow) throws Exception {
        DayOfTvPrograms one = new DayOfTvPrograms();

        // 日期行，计算总天数（列）
        Row rowDate = sheet.getRow(2);

        for (int j = 4; j < endRow; j++) {
            // 读取一行
            Row row = sheet.getRow(j);

            if (null == row) {
                continue;
            }

            String date = rowDate.getCell(col).getStringCellValue();
            String startTime = date + " " + row.getCell(1).getStringCellValue();
            String name = row.getCell(col).getStringCellValue();
            String duration = row.getCell(2).getStringCellValue();
            // 处理时长，空白或0
            if (StringUtils.isBlank(duration) || "0".equals(duration)) {
                duration = "00:00:00:00";
            }
            // 校验数据
            checkData(j, startTime, duration);

            // 添加节目单
            one.add(name, date, startTime, duration);

        }

        return one;
    }

    private static void checkData(int row, String startTime, String duration) throws Exception {

        // 格式化校验
        Date date1 = DateUtils.parse(startTime, "yyyy.MM.dd HH:mm:ss");
        Date date2 = DateUtils.parse(duration, "HH:mm:ss:00");

        if (date1 == null || date2 == null) {
            throw new Exception("第" + row + "行时间格式错误");
        }

    }

    public static void main(String[] args) throws Exception {
        download();
    }

    public static void download() throws Exception {

        int cellNo = 0;// 单元格下标
        Cell cell = null;// 单元格对象
        int rowNo = 0;// 行下标
        Row row = null;// 行对象

        // 创建工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 创建工作表
        Sheet sheet = workbook.createSheet();
        // 设置单元格宽
        sheet.setColumnWidth(cellNo++, 6*256);
        sheet.setColumnWidth(cellNo++, 10*256);
        sheet.setColumnWidth(cellNo++, 14*256);
        sheet.setColumnWidth(cellNo++, 23*256);
        sheet.setColumnWidth(cellNo++, 23*256);
        sheet.setColumnWidth(cellNo++, 23*256);
        sheet.setColumnWidth(cellNo++, 23*256);
        sheet.setColumnWidth(cellNo++, 23*256);
        sheet.setColumnWidth(cellNo++, 23*256);
        sheet.setColumnWidth(cellNo++, 23*256);

        // 第四步，创建单元格，并设置值表头 设置表头居中
//        HSSFCellStyle style = workbook.createCellStyle();
//        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直
//        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平

        // 标题样式
        HSSFFont titleFont = workbook.createFont();
        titleFont.setFontName("宋体");
        titleFont.setFontHeightInPoints((short) 16);// 字体大小
        titleFont.setBold(true);
        HSSFCellStyle titleStyle = workbook.createCellStyle();
        titleStyle.setFont(titleFont);
        titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
        titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
//        titleStyle.setLocked(true);

        //--------------设置标题--------------
        row = sheet.createRow(0);// 创建大标题的行对象
        row.setHeightInPoints(26);// 设置行高
        cell = row.createCell(0);// 在当前行上创建一个单元格对象
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 9));// 合并单元格
        cell.setCellValue("节目播出单");// 设置单元格内容
        cell.setCellStyle(titleStyle);// 设置单元格样式

        // 备注样式
        HSSFFont noteFont = workbook.createFont();
        noteFont.setFontName("宋体");
        noteFont.setFontHeightInPoints((short) 11);// 字体大小
        noteFont.setBold(true);
        HSSFCellStyle noteStyle = workbook.createCellStyle();
        noteStyle.setFont(noteFont);
        noteStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
        noteStyle.setWrapText(true);
//        noteStyle.setLocked(true);

        //--------------设置备注--------------
        row = sheet.createRow(1);// 创建大标题的行对象
        row.setHeightInPoints(92);// 设置行高
        cell = row.createCell(0);// 在当前行上创建一个单元格对象
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 9));// 合并单元格
        cell.setCellValue("备注:\r\n" +
                "1、导入日期必须是连续的，不支持导入今日之前的节目单，今日已开始的节目不支持修改\r\n" +
                "2、各个节目之间时间不得有交集\r\n" +
                "3、#号表示当前为空档节目\r\n" +
                "4、单个节目时长不得超过6小时，超过请拆分成多个节目");// 设置单元格内容
        cell.setCellStyle(noteStyle);


        // 日期样式
        HSSFFont dateFont = workbook.createFont();
        dateFont.setFontName("宋体");
        dateFont.setFontHeightInPoints((short) 11);// 字体大小
        dateFont.setBold(true);
        dateFont.setColor(HSSFFont.COLOR_RED);
        HSSFCellStyle dateStyle = workbook.createCellStyle();
        dateStyle.setFont(dateFont);
        dateStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
        dateStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
        dateStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
        dateStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
        dateStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
        dateStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
//        dateStyle.setLocked(true);

        //--------------设置日期--------------
        row = sheet.createRow(2);
        row.setHeightInPoints(23);// 设置行高
        String[] dates = new String[]{"","","","2020.09.04","2020.09.05","2020.09.06","2020.09.07","2020.09.08","2020.09.09","2020.09.10"};
        // 创建单元格对象，设置内容与样式
        cellNo = 0;
        for (String title : dates) {
            cell = row.createCell(cellNo++);
            cell.setCellValue(title);
            cell.setCellStyle(dateStyle);
        }

        // 列标题样式
        HSSFFont headerFont = workbook.createFont();
        headerFont.setFontName("宋体");
        headerFont.setFontHeightInPoints((short) 9);// 字体大小
        headerFont.setBold(true);
        headerFont.setColor(HSSFColor.WHITE.index);
        HSSFCellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(headerFont);
        headerStyle.setFillForegroundColor(HSSFColor.ROYAL_BLUE.index); // 设置背景色
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
        headerStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
        headerStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
        headerStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
        headerStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
        headerStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
//        dateStyle.setLocked(true);

        //--------------设置列标题--------------
        row = sheet.createRow(3);
        row.setHeightInPoints(16.5f);// 设置行高
        String[] titles = new String[]{"序号","播出时间","时长","节目名称（周一）","节目名称（周二）","节目名称（周三）","节目名称（周四）","节目名称（周五）","节目名称（周六）","节目名称（周七）"};
        // 创建单元格对象，设置内容与样式
        cellNo = 0;
        for (String title : titles) {
            cell = row.createCell(cellNo++);
            cell.setCellValue(title);
            cell.setCellStyle(headerStyle);
        }

        // 数据行样式
        HSSFFont rowFont = workbook.createFont();
        rowFont.setFontName("宋体");
        rowFont.setFontHeightInPoints((short) 9);// 字体大小
        rowFont.setBold(true);
        rowFont.setColor(HSSFFont.COLOR_RED);
        HSSFCellStyle rowStyle = workbook.createCellStyle();
        rowStyle.setFont(rowFont);
        rowStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
        rowStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
        rowStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
        rowStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
        rowStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
        rowStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框

        // 一行
        row = sheet.createRow(4);
        row.setHeightInPoints(13.5f);// 设置行高
        String row4[] = {"1","00:00:00","00:55:00:00","节目1","节目1","节目1","节目1","节目1","节目1","节目1"};
        // 创建单元格对象，设置内容与样式
        cellNo = 0;
        for (String title : row4) {
            cell = row.createCell(cellNo++);
            cell.setCellValue(title);
            cell.setCellStyle(rowStyle);
        }

        //--------------模拟数据输出--------------
//        row = sheet.createRow(++rowNo);
//        row.setHeightInPoints(24);// 设置行高

//        cellNo = 1;// 重置单元格下标为1
//        cell = row.createCell(cellNo++);
//        cell.setCellValue("200000");// 设置单元格内容，学号200000
//        cell.setCellStyle(this.text(workbook));

//        cell = row.createCell(cellNo++);
//        cell.setCellValue("老王");// 设置单元格内容，老王
//        cell.setCellStyle(this.text(workbook));

//        cell = row.createCell(cellNo++);
//        cell.setCellValue("59.9");// 设置单元格内容，59.9分
//        cell.setCellStyle(this.text(workbook));

        // 保存，关闭流对象，在C盘生成excel测试.xls文件
        OutputStream os = new FileOutputStream("D:\\excel测试.xls");
        workbook.write(os);
        os.close();
    }

}
