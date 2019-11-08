package com.shijing.nopainnogain.ldap;

public class BlueCloudUserInfo {
    private String loginId;

    private String userName;

    private String departmentId;

    public BlueCloudUserInfo(String loginId, String userName, String departmentId) {
        this.loginId = loginId;
        this.userName = userName;
        this.departmentId = departmentId;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "BlueCloudUserInfo{" +
                "loginId='" + loginId + '\'' +
                ", userName='" + userName + '\'' +
                ", departmentId='" + departmentId + '\'' +
                '}';
    }
}
