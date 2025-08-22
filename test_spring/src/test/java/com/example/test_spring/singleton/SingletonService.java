package com.example.test_spring.singleton;

public class SingletonService {

    // 1개의 객체 인스턴스만 존재해야 하므로 private로 막아서 new 키워드로 객체 인스턴스가 생성되는 것을 막음
    private static final SingletonService instance = new SingletonService();

    // public으로 열어서 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회하도록 함
    public static SingletonService getInstance() {
        return instance;
    }

    // 생성자를 private로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하게 막음
    private SingletonService() {}

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
