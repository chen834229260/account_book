package com.example.test.strategymode;

/**
 * @author: ckx
 * @date: 2020/7/22
 * @description:
 */
public abstract class CashSuper {
    /**
     *
     * @param money 原价
     * @return 返回当前价
     */
    Double acceptCash(Double money) {
        return money;
    }
}
