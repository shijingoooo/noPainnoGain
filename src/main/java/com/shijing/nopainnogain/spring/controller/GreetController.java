package com.shijing.nopainnogain.spring.controller;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

@RestController
@RequestMapping("/greet")
public class GreetController {

    private static final Logger logger = LoggerFactory.getLogger(GreetController.class);

    @GetMapping("/hello")
    public String hello(HttpServletRequest request) {
        Map<String, String> map = new TreeMap<>(Comparator.naturalOrder());
        setResponseMap(request, map);
        Gson gson = new Gson();
        return gson.toJson(map);
    }

    @GetMapping("/bye")
    public String bye(HttpServletRequest request) {
        Map<String, String> map = new TreeMap<>(Comparator.naturalOrder());
        setResponseMap(request, map);
        Gson gson = new Gson();
        return gson.toJson(map);
    }

    private void setResponseMap(HttpServletRequest request, Map<String, String> map) {
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String value = request.getHeader(name);
            map.put(name, value);
        }
        /*logger.info("URL = {}", request.getRequestURL());
        logger.info("URI = {}", request.getRequestURI());
        logger.info("QueryString = {}", request.getQueryString());
        logger.info("RemoteAddr = {}", request.getRemoteAddr());
        logger.info("RealAddr = {}", getIpAdrress(request));
        logger.info("PathInfo = {}", request.getPathInfo());
        logger.info("RemoteHost = {}", request.getRemoteHost());
        logger.info("RemotePort = {}", request.getRemotePort());
        logger.info("LocalPort = {}", request.getLocalPort());
        logger.info("LocalAddr = {}", request.getLocalAddr());
        logger.info("LocalName = {}", request.getLocalName());*/
        map.put("URL", request.getRequestURL().toString());
        map.put("URI", request.getRequestURI());
        map.put("QueryString", request.getQueryString());
        map.put("RemoteAddr", request.getRemoteAddr());
        map.put("RealAddr", getIpAdrress(request));
        map.put("PathInfo", request.getPathInfo());
        map.put("RemoteHost", request.getRemoteHost());
        map.put("RemotePort", String.valueOf(request.getRemotePort()));
        map.put("LocalPort", String.valueOf(request.getLocalPort()));
        map.put("LocalAddr", request.getLocalAddr());
        map.put("LocalName", request.getLocalName());
        map.put("RequestMethod", request.getMethod());
    }

    public static String getIpAdrress(HttpServletRequest request) {
        String Xip = request.getHeader("X-Real-IP");
        String XFor = request.getHeader("X-Forwarded-For");
        if(!StringUtils.isEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)){
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = XFor.indexOf(",");
            if(index != -1){
                return XFor.substring(0,index);
            }else{
                return XFor;
            }
        }
        XFor = Xip;
        if(!StringUtils.isEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)){
            return XFor;
        }
        if (StringUtils.isEmpty(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("HTTP_CLIENT_IP");
        }
        if (StringUtils.isEmpty(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (StringUtils.isEmpty(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getRemoteAddr();
            if (XFor.equals("127.0.0.1") || XFor.equals("0:0:0:0:0:0:0:1")) {
                // 根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                    XFor = inet.getHostAddress();
                } catch (UnknownHostException e) {
                    logger.error(e.getLocalizedMessage());
                }
            }
        }
        return XFor;
    }

}
