package com.zz.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zz.dao.AssetInOutDao;
import com.zz.model.AssetInOut;

/***
 * 收入支出的业务逻辑类
 * @author 
 *
 */
@Service
public class AssetInOutService {
    
	/*用于存储AssetInOut集合*/
	private List<AssetInOut> list;
	
	public List<AssetInOut> getList() {
		return list;
	}

	public void setList(List<AssetInOut> list) {
		this.list = list;
	}

	/*注解方式注入依赖关系*/
	@Resource
	private AssetInOutDao assetInOutDao;
	
	public AssetInOutDao getAssetInOutDao() {
		return assetInOutDao;
	}

	public void setAssetInOutDao(AssetInOutDao assetInOutDao) {
		this.assetInOutDao = assetInOutDao;
	}

	/***
	 * 业务层完成收支记录新增
	 * @param assetInOut
	 */
	public void assetSave(AssetInOut assetInOut) {
		// TODO Auto-generated method stub
		assetInOutDao.assetSave(assetInOut);
	}

	/***
	 * 业务层删除操作，根据id
	 * @param id
	 */
	public void assetDelete(int id) {
		// TODO Auto-generated method stub
		
		assetInOutDao.assetDelete(id);
	}

	/***
	 * 业务逻辑层，用于收支信息记录的修改
	 * @param assetInOut
	 */
	public void assetUpdate(AssetInOut assetInOut) {
		// TODO Auto-generated method stub
		
		assetInOutDao.assetUpdate(assetInOut);
	}

	/***
	 * 业务逻辑层，用于查询所有收支信息记录
	 * @param assetInOut
	 */
	public List<AssetInOut> assetQueryAll() {
		
		list=assetInOutDao.assetQueryAll();
		return list;
	}

	/***
	 * 根据日期和类型查询收支结果
	 * @param type 
	 * @param time 
	 * @return
	 */
	public List<AssetInOut> assetQueryByTimeAndType(Date time, String type) {
		// TODO Auto-generated method stub
		list=assetInOutDao.assetQueryByTimeAndType(time,type);
		return list;
	}

	/***
	 * 根据该年去查询该年的支出
	 * @param year
	 * @return
	 */
	public double assetQueryOut(int year) {
		// TODO Auto-generated method stub
		
		return assetInOutDao.assetQueryOut(year);
	}

	/***
	 * 根据该年去查询该年的收入
	 * @param year
	 * @return
	 */
	public BigDecimal assetQueryIn(int year) {
		// TODO Auto-generated method stub
		
		return assetInOutDao.assetQueryIn(year);
	}

	public void testPage() {
		// TODO Auto-generated method stub
		System.out.println("访问到service层testPage");
		assetInOutDao.testPage();
	}
}
