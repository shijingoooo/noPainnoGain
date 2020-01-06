package com.shijing.nopainnogain.designpattern.bridge;

/**
 * @description:
 * @author: shijing
 * @create: 2020-01-05 22:42
 **/
public class Test {
    public static void main(String[] args) {
        Brand brand = new XiaoMi();
        FolderPhone folderPhone = new FolderPhone(brand);
        folderPhone.open();
        folderPhone.call();
        folderPhone.close();

        brand = new Vivo();
        UpRightPhone upRightPhone = new UpRightPhone(brand);
        upRightPhone.open();
        upRightPhone.call();
        upRightPhone.close();
    }
}
