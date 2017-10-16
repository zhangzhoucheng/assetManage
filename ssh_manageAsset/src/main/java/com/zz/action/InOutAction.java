package com.zz.action;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.zz.model.AssetInOut;
import com.zz.service.AssetInOutService;

/*实现编辑功能的action，由提交的收支类（包括除了id不能编辑外，其他属性的值），来完成数据库的修改*/
/*当然为了简便代码此处action中也包括对数据的修改，删除，查询的功能，利用通配符实现action*/
public class InOutAction {

	/*此处num用于获取删除，编辑操作时候的id从而进行相关操作*/
	private int num;
	
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	/*此处类型，用于做查询时候下拉框选择：收入，支出，全部的值获取*/
	private String type;
	
	public String getType() {
		return type;
	}

	/*此处time用户查询时候也要满足日期去查询*/
	private Date time;
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	
	
	public void setType(String type) {
		this.type = type;
	}

	/*收支记录集合*/
	private List<AssetInOut> list;

	public List<AssetInOut> getList() {
		return list;
	}

	public void setList(List<AssetInOut> list) {
		this.list = list;
	}

	/*注解方式注入依赖关系*/
	@Resource
	private AssetInOutService assetInOutService;

	public AssetInOutService getAssetInOutService() {
		return assetInOutService;
	}

	public void setAssetInOutService(AssetInOutService assetInOutService) {
		this.assetInOutService = assetInOutService;
	}
	
	private AssetInOut assetInOut;
	public AssetInOut getAssetInOut() {
		return assetInOut;
	}

	public void setAssetInOut(AssetInOut assetInOut) {
		this.assetInOut = assetInOut;
	}

	/***
	 * 完成收支记录的新增
	 */
	public void assetSave(){
		
		assetInOut.setMoney(12);
		assetInOut.setType("测试");
		assetInOutService.assetSave(assetInOut);
	}
	
	/***
	 * 完成收支记录的删除
	 */
	public void assetDelete(){
		
		assetInOutService.assetDelete(num);
	}
	
	/***
	 * 完成收支记录的修改，id不变，其他可变
	 */
	public void assetUpdate(){
		assetInOutService.assetUpdate(assetInOut);
	}
	
	/***
	 * 查询所以有的收支信息集合
	 * @return
	 */
	public String assetQueryAll(){
		
		list=assetInOutService.assetQueryAll();
		return "success";
	}
	
	public void  assetQueryAllAjax(){
		System.out.println("请求到ajax1");
		
		ActionContext ac=ActionContext.getContext();
		 Map<String, Object>  session=ac.getSession();
		 System.out.println("hi1");
		 list=assetInOutService.assetQueryAll();
		 System.out.println("hi2");
		for(AssetInOut a:list){
			System.out.println("**"+a.toString());
		}
		 session.put("list",list);
		 
		
		
		
	}
	/***
	 * 查询该日期下的对应类型的收支信息集合
	 * @return
	 */
	public String assetQueryByTimeAndType(){
		list=assetInOutService.assetQueryByTimeAndType(time,type);
		return "success";
	}
	
	/***
	 * 查询该年的支出金额
	 * @return
	 */
	public double assetQueryOut(){
		
		/*此处需要获取年，可能获取错误*/
		int year=time.getYear();
		return assetInOutService.assetQueryOut(year);
		
	}
	
	/***
	 * 查询该年的收入金额
	 * @return
	 */
	public BigDecimal assetQueryIn(){
		
		/*此处需要获取年，可能获取错误*/
		int year=time.getYear();
		return assetInOutService.assetQueryIn(year);
		
	}
	
	
/**
 * 此处是测试page的函数
 */
	
	public String testPage(){
		System.out.println("访问到testPage");
		assetInOutService.testPage();
		System.out.println("testPage完成");
		return "testPage";
		
	}
	
	/*
	 * %%%%%关于处理曲线图的问题，首先通过当前页面获取的年份值以及月份值，从而计算出该月有多少天
	 * %%%%%之后建立两个个list<BigDecimal>集合，用于存放通过for循环查询数据库依次获取的到1号到30号（如果是30天该月）
	 * %%%%%的收入和支出的金额（没有就是0）之后就可以通过这两个集合到jsp完成图表
	 * 注：暂时省略关于此处查询写法
	 */
	
}
