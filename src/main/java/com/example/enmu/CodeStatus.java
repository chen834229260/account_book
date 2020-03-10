package com.example.enmu;

/**
 * @author: ckx
 * @date: 2020/3/9
 * @description:
 */
public enum CodeStatus {

    SUCCESS("200", "请求成功"),

    ERROR_SERVICE("500", "服务器出错了");

    private String code;
    private String message;

    CodeStatus(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
