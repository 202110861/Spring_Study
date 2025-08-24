package com.example.test_spring;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
//lombok은 getter, setter을 자동으로 만들어줌
@ToString
public class HelloLombok {
    private  String name;
    private int age;

    public static void main(String[] args) {
       HelloLombok helloLombok = new HelloLombok();
       helloLombok.setName("Lombok");

       String name = helloLombok.getName();
        System.out.println("name = " + name);

        System.out.println("name = "+ helloLombok);
    }
}
