package com.shijing.nopainnogain.designpattern.observerpattern.java;

import java.util.Observable;

public class SubjectFor3D extends Observable {
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
        setChanged();
        notifyObservers();
    }

}

