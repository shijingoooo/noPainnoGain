package com.shijing.nopainnogain.designpattern.observerpattern.java;

public class Test {
    public static void main(String[] args) {
        SubjectFor3D subjectFor3D = new SubjectFor3D();
        SubjectForSSQ subjectForSSQ = new SubjectForSSQ();

        Observer1 observer1 = new Observer1();

        observer1.registerSubject(subjectFor3D);
        observer1.registerSubject(subjectForSSQ);

        subjectFor3D.setMsg("3D");
        subjectForSSQ.setMsg("SSQ");
    }
}
