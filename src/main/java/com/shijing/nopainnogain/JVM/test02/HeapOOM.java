package com.shijing.nopainnogain.JVM.test02;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: shijing
 * @Date: 18/11/22 15 50
 * @Description: VM Args: -Xms 20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {
    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        int a = -1;
        System.out.println(a>>>1);
        /*while (true) {
            list.add(new OOMObject());
        }*/
        HeapOOM heapOOM = new HeapOOM();
        int y=heapOOM.aaa();
        System.out.println(y);
    }
    public int aaa(){
        int x=1;
        try{
            return ++x;
        }catch(Exception e){
        }finally{
            ++x;
            return x;

        }
        //System.out.println("atguigu");
    }
}
