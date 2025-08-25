package com.example.test_spring.lifeecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;

//public class NetworkClient implements InitializingBean, DisposableBean {
public class NetworkClient {
    private String url;
    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect(){
        System.out.println("connect: "+url);
    }

    public void call(String message){
        System.out.println("call : "+url+" message : "+message);
    }
    //서비스 종료시 호출
    public void disconnect(){
        System.out.println("close : "+url);
    }


    // 1. 초기화, 소멸 인터페이스 (스프링 전용 인터페이스에 의존함, 초기화/소멸 메서드 이름 변경 X, 외부 라이브러리에 적용 X)
    // 잘 사용하지 않음
//    @Override //의존관계 주입이 끝나면 호출
//    public void afterPropertiesSet() throws Exception {
//        connect();
//        call("초기화 연결 메세지");
//    }
//
//    @Override  // 종료될때 호출
//    public void destroy() throws Exception {
//        disconnect();
//    }

//    //2. 빈 등록 초기화, 소멸 메서드
//    // 설정 정보를 사용하기 대문에 코드 고칠 수 있는 외부 라이브러리도 초기화, 종료 메서드 적용 가능
//    public void init(){
//        connect();
//        call("초기화 연결 메세지");
//    }
//
//    public void close(){
//        disconnect();
//    }

    //3. 에노테이션
    // 최신 스프링에서 가장 권장
    // 단점 : 외부 라이브러리에는 적용 X (두번째 방식 사용하자!)
    @PostConstruct
    public void init(){
        connect();
        call("초기화 연결 메세지");
    }
    @PreDestroy
    public void close(){
        disconnect();
    }
}
