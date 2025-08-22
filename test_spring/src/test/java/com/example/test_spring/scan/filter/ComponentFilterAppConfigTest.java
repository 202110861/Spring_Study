package com.example.test_spring.scan.filter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ComponentFilterAppConfigTest {

    @Test
    void filterScan(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
        BeanA beanA = ac.getBean("beanA", BeanA.class);
        assertThat(beanA).isNotNull();

        assertThrows(
                NoSuchBeanDefinitionException.class,
                () -> ac.getBean("beanB", BeanB.class));

    }

    @Configuration
    @ComponentScan(
            //type= FilterType.ANNOTATION 는 기본값이라 삭제해도 상관없음
            //ASSIGNABLE_TYPE : 지정한 타입과 자식 타입을 인식해서 동작
            //ASPECJT : AspectJ 패턴 사용
            // REGEX : 정규 표현식
            // CUSTOM : TypeFilter 이라는 인터페이스를 구현해서 처리
            includeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = MyIncludeComponent.class),
            excludeFilters = @ComponentScan.Filter(type=FilterType.ANNOTATION, classes = MyExcludeComponent.class)
    )

    static class ComponentFilterAppConfig {

    }
}
