package com.founder.mediacloud.mam.tv;

import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.founder.e5.commons.ResourceMgr;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.founder.ark.common.utils.bean.ResponseObject;
import com.founder.e5.api.BaseApi;
import com.founder.e5.commons.Log;
import com.founder.e5.context.Context;
import com.founder.e5.context.E5Exception;
import com.founder.e5.web.SysUser;
import com.founder.e5.workspace.param.ProcParam;

import net.sf.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@RestController("MCMAMTvProgramApi")
@RequestMapping("/mam")
public class TvProgramController {

    private static Log logger = Context.getLog("xy.cms");

    @Autowired
    private TvProgramService mamTvProgramService;

    /**
     * 新建节目
     */
    @PostMapping(value = "/tv/programs", produces = "application/json;charset=UTF-8")
    public ResponseObject add(@RequestBody @Valid TvProgram tvProgram
            , BindingResult result
            , @RequestAttribute(value = BaseApi.USER) SysUser user) {
        if (result.hasErrors()){
            List<ObjectError> errorList = result.getAllErrors();
            if (errorList != null && !errorList.isEmpty())
                return ResponseObject.newErrorResponseObject(-1, errorList.get(0).getDefaultMessage());
        }
        try {
            long docID = mamTvProgramService.addTvProgram(tvProgram, user);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", docID);
            return ResponseObject.newSuccessResponseObject(jsonObject, "新建成功");
        } catch (E5Exception e) {
            logger.error(e);
            return ResponseObject.newErrorResponseObject(-1, e.getLocalizedMessage());
        }
    }

    /**
     * 节目详情
     */
    @GetMapping(value = "/tv/programs", produces = "application/json;charset=UTF-8")
    public ResponseObject detail(@RequestParam String id) {
        try {
            return ResponseObject.newSuccessResponseObject(mamTvProgramService.getTvProgram(id), "获取成功");
        } catch (E5Exception e) {
            logger.error(e);
            return ResponseObject.newErrorResponseObject(-1, e.getLocalizedMessage());
        }
    }

    /**
     * 修改节目
     */
    @PutMapping(value = "/tv/programs", produces = "application/json;charset=UTF-8")
    public ResponseObject update(@RequestBody @Valid TvProgram tvProgram
            , BindingResult result
            , @RequestAttribute(value = BaseApi.USER) SysUser user
            , @RequestAttribute(value = BaseApi.PROCPARAM) ProcParam procParam) {
        if (result.hasErrors()){
            List<ObjectError> errorList = result.getAllErrors();
            if (errorList != null && !errorList.isEmpty())
                return ResponseObject.newErrorResponseObject(-1, errorList.get(0).getDefaultMessage());
        }
        try {
            long docID = mamTvProgramService.updateTvProgram(tvProgram, user, procParam);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", docID);
            return ResponseObject.newSuccessResponseObject(jsonObject, "更新成功");
        } catch (E5Exception e) {
            logger.error(e);
            return ResponseObject.newErrorResponseObject(-1, e.getLocalizedMessage());
        }
    }

    /**
     * 删除一个节目或多个节目
     */
    @PostMapping(value = "/tv/programs/delete", produces = "application/json;charset=UTF-8")
    public ResponseObject delete(@RequestBody String ids
            , @RequestAttribute(value = BaseApi.USER) SysUser user) throws E5Exception {
        try {
            mamTvProgramService.deleteTvProgram(ids, user);
            return ResponseObject.newSuccessResponseObject(new JSONObject(), "删除成功");
        } catch (E5Exception e){
            logger.error(e);
            return ResponseObject.newErrorResponseObject(-1, e.getLocalizedMessage());
        }
    }

    /**
     * 复用节目单
     */
    @PostMapping(value = "/tv/programs/copy", produces = "application/json;charset=UTF-8")
    public ResponseObject copy(@RequestBody String params
            , @RequestAttribute(value = BaseApi.USER) SysUser user) {
        try {
            mamTvProgramService.copyTvProgram(params, user);
            return ResponseObject.newSuccessResponseObject(new JSONObject(), "复制成功");
        } catch (E5Exception e){
            logger.error(e);
            return ResponseObject.newErrorResponseObject(-1, e.getLocalizedMessage());
        }
    }

    /**
     * 导入节目单
     */
    @PostMapping(value = "/tv/programs/import")
    public ResponseObject importPrograms(@RequestAttribute(value = BaseApi.USER) SysUser user
            , @RequestBody String params) {
        try {
            mamTvProgramService.importTvProgram(user, params);
            return ResponseObject.newSuccessResponseObject(null, "导入成功");
        } catch (E5Exception e){
            logger.error(e);
            return ResponseObject.newErrorResponseObject(-1, e.getLocalizedMessage());
        }
    }

    @GetMapping(value="/tv/programs/template")
    public void files(HttpServletResponse response) {
        InputStream in = null;
        OutputStream out = null;
        try {
            // 设置文件名
            String fileName = URLEncoder.encode("电视节目单模板.xls", StandardCharsets.UTF_8.toString());
            response.setContentType("application/octet-stream;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"; filename*=utf-8''" + fileName);

            // 输出流
            out = response.getOutputStream();

            // 读取classPath下文件并获取输入流
            ClassPathResource classPathResource = new ClassPathResource("mam/电视节目单模板.xls");
            // 获得File对象，当然也可以获取输入流对象
            File file = classPathResource.getFile();
            in = new FileInputStream(file);

            // 下载
            IOUtils.copy(in, out);

        } catch (Exception e) {
            logger.error(e.getLocalizedMessage(), e);
        } finally {
            // 关闭流
            ResourceMgr.closeQuietly(in);
            ResourceMgr.closeQuietly(out);
        }
    }
}
