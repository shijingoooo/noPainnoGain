package com.shijing.nopainnogain.poi;

import com.shijing.nopainnogain.spring.controller.GreetController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @description:
 * @author: shijing
 * @create: 2020-03-17 11:32
 **/
@RestController
public class PoiController {

    private static final Logger logger = LoggerFactory.getLogger(GreetController.class);

    /**
     */
    @GetMapping(value = "/poi/word/download")
    public void resultDownload(HttpServletResponse response) {
        try {
            Word word = new Word();
            //保存文件名
            String fileName = "1.docx";
            // 解决不同浏览器出现的乱码
            fileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8.toString());
            response.setContentType("application/octet-stream;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"; filename*=utf-8''" + fileName);
            try (OutputStream out = response.getOutputStream()) {
                word.export().write(out);
            }
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage(), e);
        }
    }

}
