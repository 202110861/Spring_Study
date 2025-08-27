package com.example.test_spring.common;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
//proxyMode = ScopedProxyMode.TARGET_CLASS를 추가하면 MyLogger의 가짜 프록시를 만들어두고 HTTP request와 상관없이 가짜 프록시 클래스를 다른 빈에 미리 주입해 둘 수 있음
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS) //빈은 HTTP 요청당 하나씨 생성, 끝나는 시점에 소멸됨.

//로그를 출력하기 위한 클래스
public class MyLogger {
    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }
    public void log(String message) {
        System.out.println("["+uuid+"] ["+requestURL+"] "+message);
    }

    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.println("["+uuid+"] request scope bean create : "+this);
    }

    @PreDestroy
    public void close() {
        System.out.println("["+uuid+"] request scope bean close : "+this);
    }
}
