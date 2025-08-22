package com.example.test_spring.singleton;

public class StatefulService {
    //private int price; // 상태를 유지하는 필드


    //아래 코드는 상태를 유지함
//    public void order(String name, int price){
//        System.out.println("name = "+name+" price = "+price);
//        this.price = price; //여기가 문제
//    }

    // 무상태로 설계한 코드
    public int order(String name, int price){
        System.out.println("name = "+name+" price = "+price);
        return price;
    }
//    public int getPrice(){
//       return price;
//    }
}
