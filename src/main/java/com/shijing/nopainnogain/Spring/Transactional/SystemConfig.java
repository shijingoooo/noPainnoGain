package com.shijing.nopainnogain.Spring.Transactional;

import javax.persistence.*;

/**
 * @Auther: shijing
 * @Date: 19/7/3 15:06
 * @Description: system_config表 实体类
 */
@Entity
@Table(name = "system_config")
public class SystemConfig {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "sname", nullable = false)
    private String sname;

    @Column(name = "scode", nullable = false)
    private String scode;

    @Column(name = "sstatus", nullable = false)
    private String sstatus;

    @Column(name = "sdescribe")
    private String sdescribe;

    public SystemConfig() {
    }

    public SystemConfig(String sname, String scode, String sstatus, String sdescribe) {
        this.sname = sname;
        this.scode = scode;
        this.sstatus = sstatus;
        this.sdescribe = sdescribe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getScode() {
        return scode;
    }

    public void setScode(String scode) {
        this.scode = scode;
    }

    public String getSstatus() {
        return sstatus;
    }

    public void setSstatus(String sstatus) {
        this.sstatus = sstatus;
    }

    public String getSdescribe() {
        return sdescribe;
    }

    public void setSdescribe(String sdescribe) {
        this.sdescribe = sdescribe;
    }

}
