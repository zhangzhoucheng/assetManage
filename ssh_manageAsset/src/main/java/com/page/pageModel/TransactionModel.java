/*****************************************************************************
 * Copyright (c) 2015, www.qingshixun.com
 *
 * All rights reserved
 *
 *****************************************************************************/
package com.page.pageModel;

/**
 * 交易数据实体类
 * 
 * @author QingShiXun
 * 
 * @version 1.0
 */
import java.io.Serializable;

public class TransactionModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private double amount;//销售金额
	private String region;//地区
	private Integer month;//月份

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

}
