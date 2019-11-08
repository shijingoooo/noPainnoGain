package com.shijing.nopainnogain.swagger2;

public class Result {
    private int code;
    private String msg;
    private Object data;

    public Result() {
    }

    private void common(ReturnCode returnCode) {
        this.code = returnCode.getCode();
        this.msg = returnCode.getMsg();
    }

    public void setResult(ReturnCode returnCode) {
        this.common(returnCode);
    }

    public void setData(ReturnCode returnCode, Object data) {
        this.common(returnCode);
        this.data = data;
    }

    public String toString() {
        return "Result{code=" + this.code + ", msg='" + this.msg + '\'' + ", data=" + this.data + '}';
    }
}
