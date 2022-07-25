package com.shijing.nopainnogain.poi;

import com.deepoove.poi.XWPFTemplate;
import org.apache.poi.xwpf.usermodel.*;

import java.util.HashMap;

public class Word {

    public XWPFDocument export() {

        XWPFDocument doc = new XWPFDocument();

        XWPFParagraph p = doc.createParagraph();// 新建一个段落

        p.setAlignment(ParagraphAlignment.CENTER);// 设置段落的对齐方式
        /*p.setBorderBottom(Borders.DOUBLE);//设置下边框
        p.setBorderTop(Borders.DOUBLE);//设置上边框
        p.setBorderRight(Borders.DOUBLE);//设置右边框
        p.setBorderLeft(Borders.DOUBLE);//设置左边框*/

        XWPFRun r = p.createRun();//创建段落文本
        r.setText("标题");

        p = doc.createParagraph();// 导语
        r = p.createRun();
        r.setBold(true);//设置为粗体
        r.setText("导语：");

        p = doc.createParagraph();// 导语内容
        r = p.createRun();
        r.setText("这里是导语");

        p = doc.createParagraph();// 空行

        p = doc.createParagraph();// 口播
        r = p.createRun();
        r.setBold(true);//设置为粗体
        r.setText("口播：");
        p = doc.createParagraph();// 口播内容
        r = p.createRun();
        r.setText("这里是口播");

        p = doc.createParagraph();// 空行

        p = doc.createParagraph();// 正文
        r = p.createRun();
        r.setBold(true);//设置为粗体
        r.setText("正文：");
        p = doc.createParagraph();// 正文内容
        r = p.createRun();
        r.setText("这里是正文");

        p = doc.createParagraph();// 空行

        p = doc.createParagraph();// 编后语
        r = p.createRun();
        r.setBold(true);//设置为粗体
        r.setText("编后语：");
        p = doc.createParagraph();// 编后语内容
        r = p.createRun();
        r.setText("这里是编后语");

        p = doc.createParagraph();// 空行

        return doc;
    }

    public XWPFTemplate template() {

        return XWPFTemplate.compile("D:\\template.docx").render(
            new HashMap<String, Object>() {{
                put("title", "标题");
                put("header", "这里是导语");
                put("speak", "这里是口播");
                put("content", "这里是内容");
                put("tail", "这里是编后语");
            }}
        );
    }


}
