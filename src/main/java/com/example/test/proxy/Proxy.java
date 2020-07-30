package com.example.test.proxy;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: ckx
 * @date: 2020/7/23
 * @description:代理
 */
@Getter
@Setter
public class Proxy implements SendGift{

    Suitors gg;

    public Proxy(SchoolGirl mm){
        gg = new Suitors(mm);
    }

    @Override
    public void GiveDolls() {
        gg.GiveDolls();
    }

    @Override
    public void GiveFlowers() {
        gg.GiveFlowers();
    }

    @Override
    public void GiveChocolate() {
        gg.GiveChocolate();
    }
}
