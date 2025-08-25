package com.example.test_spring.lifeecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {
    @Test
    public void lifeCycleTst(){
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig{
        //@Bean (initMethod = "init", destroyMethod = "close")
        //destroyMethod 의 기본값은 (inferred) (추론)으로 등록 되어 있음
        // close, shutdown 라는 이름의 메서드를 자동으로 호출 (종료 메서드를 추론해서 호출)
        @Bean
        public NetworkClient networkClient(){
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://localhost:8080");
            return networkClient;
        }
    }
}
