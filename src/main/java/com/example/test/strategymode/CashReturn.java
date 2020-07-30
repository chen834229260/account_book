package com.example.test.strategymode;

/**
 * @author: ckx
 * @date: 2020/7/22
 * @description:返利收费子类
 */
public class CashReturn extends CashSuper {

    private Double moneyCondition = 0.0d;

    private Double moneyReturn = 0.0d;

    /**
     * 返利收费,初始化时必须输入返利条件和返利值,比如满300减100,则moneyCondition为300,moneyReturn为100
     * @param moneyCondition
     * @param moneyReturn
     */
    public CashReturn(String moneyCondition, String moneyReturn) {
        this.moneyCondition = Double.valueOf(moneyCondition);
        this.moneyReturn = Double.valueOf(moneyReturn);
    }

    @Override
    Double acceptCash(Double money) {
        Double result = money;
        //若大于返利条件,则减去返利值
        if (money >= moneyCondition){
            result = money - (money / moneyCondition) * moneyReturn;
        }
        return result;
    }
}
