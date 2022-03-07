package com.nowcoder.community.controller.advice;

import com.nowcoder.community.util.CommunityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@ControllerAdvice(annotations = Controller.class)//扫描controller注解的bean
public class ExceptionAdvice {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);

    @ExceptionHandler({Exception.class})
    public void handleException(Exception e, HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.error("服务器发生异常: " + e.getMessage());
        for (StackTraceElement element : e.getStackTrace()) {//遍历错误栈
            logger.error(element.toString());
        }

        String xRequestedWith = request.getHeader("x-requested-with");//请求方式
        if ("XMLHttpRequest".equals(xRequestedWith)) {//如果返回值是XMLHttpRequest，说明是异步请求，只有异步请求才返回xml或json
            response.setContentType("application/plain;charset=utf-8");
            PrintWriter writer = response.getWriter();//获取输出流
            writer.write(CommunityUtil.getJSONString(1, "服务器异常!"));//如果是
        } else {
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }

}
