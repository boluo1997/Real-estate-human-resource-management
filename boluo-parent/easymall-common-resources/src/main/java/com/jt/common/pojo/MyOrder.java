package com.jt.common.pojo;

import java.util.Date;

public class MyOrder {
	//根据驼峰命名定义属性
	
	private int myorderId;				//订单ID
	private String myorderSalesmanId;		//业务员ID
	private String myorderSalesmanName;		//业务员名字
	private String myorderConsumerName;		//客户名字
	private String myorderConsumerPhone;	//客户手机号
	private String myorderCity;				//所在城市
	private String myorderPlotName;		//小区名称
	private Date myorderCreateTime;		//订单创建时间

	//getter setter

	public int getMyorderId() {
		return myorderId;
	}

	public void setMyorderId(int myorderId) {
		this.myorderId = myorderId;
	}

	public String getMyorderSalesmanId() {
		return myorderSalesmanId;
	}

	public void setMyorderSalesmanId(String myorderSalesmanId) {
		this.myorderSalesmanId = myorderSalesmanId;
	}

	public String getMyorderSalesmanName() {
		return myorderSalesmanName;
	}

	public void setMyorderSalesmanName(String myorderSalesmanName) {
		this.myorderSalesmanName = myorderSalesmanName;
	}

	public String getMyorderConsumerName() {
		return myorderConsumerName;
	}

	public void setMyorderConsumerName(String myorderConsumerName) {
		this.myorderConsumerName = myorderConsumerName;
	}

	public String getMyorderConsumerPhone() {
		return myorderConsumerPhone;
	}

	public void setMyorderConsumerPhone(String myorderConsumerPhone) {
		this.myorderConsumerPhone = myorderConsumerPhone;
	}

	public String getMyorderCity() {
		return myorderCity;
	}

	public void setMyorderCity(String myorderCity) {
		this.myorderCity = myorderCity;
	}

	public String getMyorderPlotName() {
		return myorderPlotName;
	}

	public void setMyorderPlotName(String myorderPlotName) {
		this.myorderPlotName = myorderPlotName;
	}

	public Date getMyorderCreateTime() {
		return myorderCreateTime;
	}

	public void setMyorderCreateTime(Date myorderCreateTime) {
		this.myorderCreateTime = myorderCreateTime;
	}


	//toString()


	@Override
	public String toString() {
		return "MyOrder{" +
				"myorderId='" + myorderId + '\'' +
				", myorderSalesmanId='" + myorderSalesmanId + '\'' +
				", myorderSalesmanName='" + myorderSalesmanName + '\'' +
				", myorderConsumerName='" + myorderConsumerName + '\'' +
				", myorderConsumerPhone='" + myorderConsumerPhone + '\'' +
				", myorderCreateTime=" + myorderCreateTime +
				'}';
	}
}
