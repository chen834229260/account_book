package com.example.test.strategymode;

/**
 * @author: ckx
 * @date: 2020/7/22
 * @description:
 */
public class CashFactory {
    /**
     * 现金收取工厂
     *
     * @param type
     * @return
     */
    public static CashSuper createCashAccept(String type) {
        CashSuper cs = null;
        switch (type) {
            case "正常收费":
                cs = new CashNormal();
                break;
            case "满300返100":
                cs = new CashReturn("300", "100");
                break;
            case "打八折":
                cs = new CashRebate("0.8");
                break;
            default:
                break;
        }
        return cs;
    }
}
