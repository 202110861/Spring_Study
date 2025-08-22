package com.example.test_spring;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


@Configuration
@ComponentScan(
        //basePackage 지정 이유 : 탐색할 패키지 시작 위치 지정. 패키지 포함해서 하위 패키지 모두 탐색
        //여러개 지정 방법 :  {"", ""}
        //지정하지 않으면 ComponentScan이 붙은 설정 정보 클래스의 패키지가 시작 위치가 됨.
        //권장하는 방법 : 프로젝트 시작 루트 (com.example.test_spring)에 AppConfig 같은 메인 설정 정보를 두고 basePackages 생략
        basePackages = "com.example.test_spring",
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = Configuration.class)
)
//다른 파일에서 bean으로 등록한 것들은 제외하기 위해 filter 사용
// 기존 예제 코드를 최대한 남기고 유지하기 위해 위와같은 방법 사용

public class AutoAppConfig {


}