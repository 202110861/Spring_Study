package com.example.test_spring.web;

import com.example.test_spring.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequiredArgsConstructor
public class LogDemoController {
    private final LogDemoService logDemoService;
    //1. ObjectProvider 덕분에 .getObject()를 호출하는 시점까지 request scope의 빈 생성을 지연할 수 있음
//    private final ObjectProvider<MyLogger> myLoggerProvider;
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        String requestURI = request.getRequestURI().toString();//고객이 어떤 Url로 요청했는지 알 수 있음
//        MyLogger myLogger = myLoggerProvider.getObject(); //이때 만들어짐

        myLogger.setRequestURL(requestURI);

        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }

}
