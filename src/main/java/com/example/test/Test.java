package com.example.test;


import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

/**
 * @author: ckx
 * @date: 2020/4/1
 * @description:简单工厂模式
 */
public class Test {

    public static void main(String[] args){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入数字A：");
            String strNumberA = scanner.next();
            System.out.println("请选择运算符号(+、-、*、/)：");
            String strOperate = scanner.next();
            System.out.println("请输入数字B：");
            String strNumberB = scanner.next();
            Operation oper = OperationFactory.CreateOperate(strOperate);
            oper.set_numberA(Double.valueOf(strNumberA));
            oper.set_numberB(Double.valueOf(strNumberB));
            System.out.println("结果是：" + oper.GetResult());
        } catch (Exception ex) {
            System.out.println("您的输入有错：" + ex.getMessage());
        }

    }

}


@Getter
@Setter
class Operation {

    private double _numberA = 0;
    private double _numberB = 0;

    public double GetResult() {
        double result = 0;
        return result;
    }
}

/**
 * 加法
 */
class OperationAdd extends Operation {

    @Override
    public double GetResult() {
        double result = 0;
        result = get_numberA() + get_numberB();
        return result;
    }
}

/**
 * 减法
 */
class OperationSub extends Operation {
    @Override
    public double GetResult() {
        double result = 0;
        result = get_numberA() - get_numberB();
        return result;
    }
}

/**
 * 乘法
 */
class OperationMul extends Operation {
    @Override
    public double GetResult() {
        double result = 0;
        result = get_numberA() * get_numberB();
        return result;
    }
}

/**
 * 除法
 */
class OperationDiv extends Operation {
    @Override
    public double GetResult() {
        double result = 0;
        result = get_numberA() / get_numberB();
        return result;
    }
}

class OperationFactory {
    public static Operation CreateOperate(String operate) {
        Operation oper = null;
        switch (operate) {
            case "+":
                oper = new OperationAdd();
                break;
            case "-":
                oper = new OperationSub();
                break;
            case "*":
                oper = new OperationMul();
                break;
            case "/":
                oper = new OperationDiv();
                break;
        }
        return oper;
    }
}