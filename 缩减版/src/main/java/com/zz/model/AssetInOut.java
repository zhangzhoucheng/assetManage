package com.zz.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/***
 * 财产收入支出类
 * @author zhangzhou
 *
 */
@Entity
@Table(name="tb_sshAssetInOut")
public class AssetInOut {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String userName;
	private String type;/*类型，值有两个：收入，支出*/
	private double money;/*收支的金钱，此处注意对bigDecimal对象的处理*/
	private Date time;
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	private String remark;/*备注信息，用于说明金钱来源或者用途*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "AssetInOut [id=" + id + ", userName=" + userName + ", type=" + type + ", money=" + money + ", remark="
				+ remark + "]";
	}
	
}
