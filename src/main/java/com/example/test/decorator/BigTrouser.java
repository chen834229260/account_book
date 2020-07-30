package com.example.test.decorator;

/**
 * @author: ckx
 * @date: 2020/7/23
 * @description:
 */
public class BigTrouser extends Finery{
    @Override
    public void show() {
        System.out.println("垮裤");
        super.show();
    }
}