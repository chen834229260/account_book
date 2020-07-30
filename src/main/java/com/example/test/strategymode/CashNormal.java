package com.example.test.strategymode;

/**
 * @author: ckx
 * @date: 2020/7/22
 * @description:正常收费子类
 */
public class CashNormal extends CashSuper {
    @Override
    Double acceptCash(Double money) {
        return money;
    }
}
