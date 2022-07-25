package com.founder.xy.nis.web;

import com.founder.allmedia.difftrace.common.DateUtils;
import com.founder.ark.common.utils.bean.ResponseObject;
import com.founder.e5.api.BaseApi;
import com.founder.e5.commons.Log;
import com.founder.e5.context.Context;
import com.founder.e5.context.E5Exception;
import com.founder.e5.web.SysUser;
import com.founder.e5.workspace.param.ProcParam;
import com.founder.xy.commons.LibHelper;
import com.founder.xy.nis.Vote;
import com.founder.xy.nis.service.NisVoteService;
import io.swagger.annotations.Api;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

/**
 * Created by shijing on 2019/5/9.
 */
@Api
@RestController
@RequestMapping("/nis")
public class VoteController {

    @Autowired
    private NisVoteService nisVoteService;

    private static Log logger = Context.getLog("xy.cms");

    /**
     * 添加投票
     * @param vote 投票
     * @param user 用户
     * @param procParam 操作
     * @return ResponseObject
     */
    @PostMapping(value = "/vote")
    public ResponseObject save(@RequestBody @Valid Vote vote
            , BindingResult result
            , @RequestAttribute(value = BaseApi.USER) SysUser user
            , @RequestAttribute(value = BaseApi.PROCPARAM, required = false) ProcParam procParam) {
        if (result.hasErrors()){
            List<ObjectError> errorList = result.getAllErrors();
            if (errorList != null && !errorList.isEmpty())
                return ResponseObject.newErrorResponseObject(-1, errorList.get(0).getDefaultMessage());
        }
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", LibHelper.getVote() + "," + nisVoteService.addVote(vote, user, procParam));
            return ResponseObject.newSuccessResponseObject(jsonObject, "add vote success");
        } catch (E5Exception e) {
            logger.error(e);
            return ResponseObject.newErrorResponseObject(-1, e.getLocalizedMessage());
        }
    }

    /**
     * 修改投票
     * @param vote 投票
     * @param user 用户
     * @param procParam 操作
     * @return ResponseObject
     */
    @PutMapping(value = "/vote")
    public ResponseObject update(@RequestBody @Valid Vote vote
            , BindingResult result
            , @RequestAttribute(value = BaseApi.USER) SysUser user
            , @RequestAttribute(value = BaseApi.PROCPARAM, required = false) ProcParam procParam) {
        if (result.hasErrors()){
            List<ObjectError> errorList = result.getAllErrors();
            if (errorList != null && !errorList.isEmpty())
                return ResponseObject.newErrorResponseObject(-1, errorList.get(0).getDefaultMessage());
        }
        if (vote.getId() <= 0)
            return ResponseObject.newErrorResponseObject(-1, "id is null");
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", nisVoteService.updateVote(vote, user, procParam));
            return ResponseObject.newSuccessResponseObject(jsonObject, "update vote success");
        } catch (E5Exception e) {
            logger.error(e);
            return ResponseObject.newErrorResponseObject(-1, e.getLocalizedMessage());
        }
    }

    /**
     * 获取投票信息
     * @param id id "39,1"
     * @return ResponseObject
     */
    @GetMapping(value = "/vote")
    public ResponseObject get(@RequestParam String id) {
        try {
            return ResponseObject.newSuccessResponseObject(nisVoteService.getVote(id), "get vote success");
        } catch (E5Exception e) {
            logger.error(e);
            return ResponseObject.newErrorResponseObject(-1, e.getLocalizedMessage());
        }
    }

    /**
     * 删除一个投票或多个投票
     * @param ids 删除投票ID
     * @param user 用户
     * @return ResponseObject
     */
    @PostMapping(value = "/vote/delete")
    public ResponseObject delete(@RequestBody String ids
            , @RequestAttribute(value = BaseApi.USER) SysUser user
            , @RequestAttribute(value = BaseApi.PROCPARAM) ProcParam procParam) throws E5Exception {
        try {
            nisVoteService.deleteVote(ids, user, procParam);
            return ResponseObject.newSuccessResponseObject(new JSONObject(), "delete vote success");
        } catch (E5Exception e){
            logger.error(e);
            return ResponseObject.newErrorResponseObject(-1, e.getLocalizedMessage());
        }
    }

    /**
     * 获取投票结果
     * @param id 投票ID
     * @return ResponseObject
     */
    @GetMapping(value = "/vote/result")
    public ResponseObject result(@RequestParam String id) {
        try {
            return ResponseObject.newSuccessResponseObject(nisVoteService.getVoteResult(id), "get voteOption success");
        } catch (E5Exception e){
            logger.error(e);
            return ResponseObject.newErrorResponseObject(-1, e.getLocalizedMessage());
        }
    }

    /**
     * 修改初始票数
     * @return ResponseObject<?>
     */
    @PutMapping(value = "/vote/option/initCount")
    public ResponseObject updateInitCount(@RequestBody String param) {
        try {
            return ResponseObject.newSuccessResponseObject(nisVoteService.updateInitCount(param), "update voteOption success");
        } catch (E5Exception e){
            logger.error(e);
            return ResponseObject.newErrorResponseObject(-1, e.getLocalizedMessage());
        }
    }

    /**
     * 下载投票明细
     * @param id "39,1"
     */
    @GetMapping(value = "/vote/result/download")
    public void resultDownload(HttpServletResponse response, @RequestParam String id) {
        try {
            Vote vote = nisVoteService.getVote(id);
            //保存文件名
            String fileName = vote.getTopic()+"投票明细"+ DateUtils.format(new Date(),"yyyy-MM-dd")+".csv";
            // 解决不同浏览器出现的乱码
            fileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8.toString());
            response.setContentType("application/octet-stream;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"; filename*=utf-8''" + fileName);
            try (OutputStream out = response.getOutputStream()) {
                //EXCEL是支持UTF-8格式的CSV文件的。但是需要添加BOM，EXCEL通过BOM识别，MS就是麻烦
                out.write(new byte []{(byte)0xEF, (byte)0xBB, (byte) 0xBF});
                out.write(nisVoteService.export(id));
            }
        } catch (Exception e) {
            logger.error("下载失败：" + e);
        }
    }
}
