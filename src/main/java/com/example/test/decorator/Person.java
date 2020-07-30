package com.example.test.decorator;

/**
 * @author: ckx
 * @date: 2020/7/23
 * @description:
 */
public class Person {
    private String name;

    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("装扮的: " + name);
    }
}
