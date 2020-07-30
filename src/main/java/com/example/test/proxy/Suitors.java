package com.example.test.proxy;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: ckx
 * @date: 2020/7/23
 * @description:追求
 */
@Getter
@Setter
public class Suitors implements SendGift{

    private SchoolGirl mm;

    public Suitors(SchoolGirl mm){
        this.mm = mm;
    }

    @Override
    public void GiveDolls() {
        System.out.println(mm +"送洋娃娃");
    }

    @Override
    public void GiveFlowers() {
        System.out.println(mm +"送花");
    }

    @Override
    public void GiveChocolate() {
        System.out.println(mm +"送巧克力");
    }
}
