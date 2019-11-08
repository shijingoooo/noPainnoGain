package com.shijing.nopainnogain.swagger2;

public enum ReturnCode {

    ERROR(100, "Error"),

    SUCCESS(0, "Success")
    ;

    private Integer code;
    private String msg;

    ReturnCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
