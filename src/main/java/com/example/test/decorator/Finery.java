package com.example.test.decorator;

/**
 * @author: ckx
 * @date: 2020/7/23
 * @description:服饰类
 */
public class Finery extends Person {
    protected Person component;

    public void Decorate(Person component) {
        this.component = component;
    }


    @Override
    public void show() {
        if (component != null) {
            component.show();
        }
    }
}
