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


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="zz_transaction")
public class TransactionModel  {
	
	
	private static final long serialVersionUID = 1L;
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
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
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private double amount;//销售金额
	private String region;//地区
	private int month;//月份
	@Override
	public String toString() {
		return "TransactionModel [id=" + id + ", amount=" + amount + ", region=" + region + ", month=" + month + "]";
	}

	
	

}
