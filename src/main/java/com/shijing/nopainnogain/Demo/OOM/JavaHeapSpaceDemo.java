package com.shijing.nopainnogain.Demo.OOM;

import java.util.Random;

public class JavaHeapSpaceDemo {
    public static void main(String[] args) {
        String str = "ABC";

        while(true) {
            str += str + new Random(11111).nextInt();
            str.intern();
        }
    }

}
