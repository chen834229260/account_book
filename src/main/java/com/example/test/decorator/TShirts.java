package com.example.test.decorator;

/**
 * @author: ckx
 * @date: 2020/7/23
 * @description:具体服饰类
 */
public class TShirts extends Finery{
    @Override
    public void show() {
        System.out.println("大T恤");
        super.show();
    }
}
