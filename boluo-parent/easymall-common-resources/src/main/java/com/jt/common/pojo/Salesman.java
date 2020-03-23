package com.jt.common.pojo;

import java.util.Date;

public class Salesman {
	private String salesmanId;
	private String salesmanName;
	private String salesmanPassword;
	private String salesmanEmail;
	private String salesmanPhone;
	private String salesmanStatus;
	private String salesmanImage;
    private Date salesmanCreateTime;
	private Date salesmanUpdateTime;

    public String getSalesmanId() {
        return salesmanId;
    }

    public void setSalesmanId(String salesmanId) {
        this.salesmanId = salesmanId;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
    }

    public String getSalesmanPassword() {
        return salesmanPassword;
    }

    public void setSalesmanPassword(String salesmanPassword) {
        this.salesmanPassword = salesmanPassword;
    }

    public String getSalesmanEmail() {
        return salesmanEmail;
    }

    public void setSalesmanEmail(String salesmanEmail) {
        this.salesmanEmail = salesmanEmail;
    }

    public String getSalesmanPhone() {
        return salesmanPhone;
    }

    public void setSalesmanPhone(String salesmanPhone) {
        this.salesmanPhone = salesmanPhone;
    }

    public String getSalesmanStatus() {
        return salesmanStatus;
    }

    public void setSalesmanStatus(String salesmanStatus) {
        this.salesmanStatus = salesmanStatus;
    }

    public String getSalesmanImage() {
        return salesmanImage;
    }

    public void setSalesmanImage(String salesmanImage) {
        this.salesmanImage = salesmanImage;
    }

    public Date getSalesmanCreateTime() {
        return salesmanCreateTime;
    }

    public void setSalesmanCreateTime(Date salesmanCreateTime) {
        this.salesmanCreateTime = salesmanCreateTime;
    }

    public Date getSalesmanUpdateTime() {
        return salesmanUpdateTime;
    }

    public void setSalesmanUpdateTime(Date salesmanUpdateTime) {
        this.salesmanUpdateTime = salesmanUpdateTime;
    }

    @Override
    public String toString() {
        return "Salesman{" +
                "salesmanId='" + salesmanId + '\'' +
                ", salesmanName='" + salesmanName + '\'' +
                ", salesmanPassword='" + salesmanPassword + '\'' +
                ", salesmanEmail='" + salesmanEmail + '\'' +
                ", salesmanPhone='" + salesmanPhone + '\'' +
                ", salesmanStatus='" + salesmanStatus + '\'' +
                ", salesmanImage='" + salesmanImage + '\'' +
                ", salesmanCreateTime=" + salesmanCreateTime +
                ", salesmanUpdateTime=" + salesmanUpdateTime +
                '}';
    }
}
