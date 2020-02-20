package com.shijing.nopainnogain.designpattern.responsibilitychain;

/**
 * @description:
 * @author: shijing
 * @create: 2020-01-19 21:33
 **/
public class DepartmentApprover extends Approver {

    public DepartmentApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if (purchaseRequest.getPrice() <= 5000F) {
            System.out.println("请求编号id= " + purchaseRequest.getId() + " 被 " + this.name + " 处理");
        } else
            approver.processRequest(purchaseRequest);
    }
}
