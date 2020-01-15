package com.shijing.nopainnogain.designpattern.iteratorpattern;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: shijing
 * @create: 2020-01-13 22:38
 **/
public class Test {
    public static void main(String[] args) {
        // 创建学院
        List<College> collegeList = new ArrayList<>();

        ComputerCollege computerCollege = new ComputerCollege();

        InfoCollege infoCollege = new InfoCollege();

        collegeList.add(computerCollege);
        collegeList.add(infoCollege);

        OutputImpl output = new OutputImpl(collegeList);
        output.printCollege();
    }



}
