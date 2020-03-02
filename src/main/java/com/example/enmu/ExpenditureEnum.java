package com.example.enmu;

/**
 * @author: ckx
 * @date: 2020/3/2
 * @description:
 */
public enum ExpenditureEnum {
    FOOD("餐饮", 1),
    PLAY("娱乐", 2),
    FINANCES("理财", 3),
    SUPPLIES("日常用品", 4),
    TRAVEL("出行", 5),
    SHOPPING("网上购物", 6),
    RENT("房租水电", 7),
    WAGE("工资",8);

    private String name;
    private Integer code;

    ExpenditureEnum(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    public Integer getCode(String name) {
        for (ExpenditureEnum expenditureEnum : ExpenditureEnum.values()) {
            if (expenditureEnum.name.equals(name)) {
                return expenditureEnum.code;
            }
        }
        return 0;
    }

    public String getCode(Integer code) {
        for (ExpenditureEnum expenditureEnum : ExpenditureEnum.values()) {
            if (expenditureEnum.code.equals(code)) {
                return expenditureEnum.name;
            }
        }
        return "";
    }
}
