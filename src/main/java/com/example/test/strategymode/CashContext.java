package com.example.test.strategymode;

/**
 * @author: ckx
 * @date: 2020/7/22
 * @description:
 */
public class CashContext {
    private CashSuper cs = null;

    /**
     * 通过构造方法传入具体的收费策略
     *
     * @param type
     */
    public CashContext(String type) {
        switch (type) {
            case "正常收费":
                cs = new CashNormal();
                break;
            case "满300减100":
                cs = new CashReturn("300", "100");
                break;
            case "打八折":
                cs = new CashRebate("0.8");
                break;
            default:
                break;
        }
    }

    /**
     * 获取收费类型不同获得计算结果
     *
     * @param money
     * @return
     */
    public Double GetResult(Double money) {
        return cs.acceptCash(money);
    }
}
