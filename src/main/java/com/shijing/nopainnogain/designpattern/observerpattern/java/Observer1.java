package com.shijing.nopainnogain.designpattern.observerpattern.java;

import java.util.Observable;
import java.util.Observer;

public class Observer1 implements Observer {

    public void registerSubject(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof SubjectFor3D) {
            SubjectFor3D subjectFor3D = (SubjectFor3D) o;
            System.out.println("SubjectFor3D: " + subjectFor3D.getMsg());
        }

        if (o instanceof SubjectForSSQ) {
            SubjectForSSQ subjectForSSQ = (SubjectForSSQ) o;
            System.out.println("SubjectFor3D: " + subjectForSSQ.getMsg());
        }
    }
}
