package com.example.test.strategymode;

/**
 * @author: ckx
 * @date: 2020/7/22
 * @description:打折收费子类
 */
public class CashRebate extends CashSuper {
    private Double moneyRebate = 1d;

    /**
     * 打折收费,初始化时,必须要输入折扣率,如八折,就0.8
     * @param moneyRebate
     */
    public CashRebate(String moneyRebate) {
        this.moneyRebate = Double.valueOf(moneyRebate);
    }

    @Override
    Double acceptCash(Double money) {
        return super.acceptCash(money);
    }
}
