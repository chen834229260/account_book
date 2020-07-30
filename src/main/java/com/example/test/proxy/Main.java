package com.example.test.proxy;

/**
 * @author: ckx
 * @date: 2020/7/23
 * @description:
 */
public class Main {
    public static void main(String[] args) {
        SchoolGirl mm=new SchoolGirl();
        mm.setName("jiaojiao");

        Proxy proxy=new Proxy(mm);
        proxy.GiveDolls();
        proxy.GiveFlowers();
        proxy.GiveChocolate();
    }
}
