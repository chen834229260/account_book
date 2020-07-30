package com.example.test.strategymode;

import java.util.Scanner;

/**
 * @author: ckx
 * @date: 2020/7/22
 * @description:策略模式 + 工厂模式
 */
public class StrategyMode {

    public static void main(String[] args) {
        StrategyMode.btnOk(2);
    }

    public static void btnOk(Integer discount) {
        Double total = 0.0;
        Scanner scanner = new Scanner(System.in);
        //单价
        String price = scanner.next();
        //数量
        String quantity = scanner.next();

        CashContext cc = new CashContext("正常收费");

        total = cc.GetResult(Double.valueOf(price) * Double.valueOf(quantity));

        System.out.println("单价为:" + price + ",数量为:" + quantity +
                ",正常价格: " + Double.valueOf(price) * Double.valueOf(quantity) + ",打折后: " + total);
    }
}
