package com.shijing.nopainnogain.designpattern.responsibilitychain;

/**
 * @description:
 * @author: shijing
 * @create: 2020-01-19 21:33
 **/
public class CollegeApprover extends Approver {

    public CollegeApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        float price = purchaseRequest.getPrice();
        if (price > 5000 && price <= 10000) {
            System.out.println("请求编号id= " + purchaseRequest.getId() + " 被 " + this.name + " 处理");
        } else
            approver.processRequest(purchaseRequest);
    }
}
