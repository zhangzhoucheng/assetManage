package com.zz.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.zz.model.AssetInOut;

/***
 * 收支dao层增删查改操作
 * @author 
 *
 */
@Repository
public class AssetInOutDao {
    
/*	通过HibernateTemplate对象去访问数据库，都不用获取session，直接使用
*/	
	
	private HibernateTemplate hibernateTemplate ;
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}             
	@Resource(name="hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
/*    HibernateTemplate用法解析
*/	
	/* delete(Object entity): 删除指定持久化实例。

	    deleteAll(Collection entities): 删除集合内全部持久化类实例。

	    find(String queryString): 根据 HQL 查询字符串来返回实例集合。

	    findByNamedQuery(String queryName): 根据命名查询返回实例集合。

	    load或get(Classentity Class,Serializable id): 根据主键加载特定持久化类的实例。

	    save(Object entity): 保存新的实例。

	    saveOrUpdate(Object entity): 根据实例状态，选择保存或者更新。

	    update(Object entity): 更新实例的状态，要求entity 是持久状态。

	    setMaxResults(intmax Results): 设置分页的大小。*/
	
	
	
	/*用于存储AssetInOut集合*/
	private List<AssetInOut> list;
	
	public List<AssetInOut> getList() {
		return list;
	}

	public void setList(List<AssetInOut> list) {
		this.list = list;
	}
	
	
	
	
	public void assetSave(AssetInOut assetInOut) {
		// TODO Auto-generated method stub
		
		/*新增一条收支记录到表中*/
		
		hibernateTemplate.save(assetInOut);
		
		
	}


	public void assetDelete(int id) {
		// TODO Auto-generated method stub
		
		/*删除操作，根据id，*/
	AssetInOut assetInOut=	hibernateTemplate.get(AssetInOut.class, id);
		hibernateTemplate.delete(assetInOut);
		
		
	}


	public void assetUpdate(AssetInOut assetInOut) {
		// TODO Auto-generated method stub
		
		/*修改信息*/
		hibernateTemplate.update(assetInOut);
	}


	
	@SuppressWarnings("unchecked")
	public List<AssetInOut> assetQueryAll() {
		// TODO Auto-generated method stub
		
		/*查询所有收支信息*/
		
     list=(List<AssetInOut>)this.hibernateTemplate.find("from AssetInOut");
		
		return list;
	}


	public List<AssetInOut> assetQueryByTimeAndType(Date time, String type) {
		// TODO Auto-generated method stub
		
		/*查询该日期下的对应类型的收支信息*/
	
		/* 实现代码处*/
		/*此处由于日期格式问题，在jsp页面获取的日期与html5格式有关，所以应该先转换成相应字符串
		之后再比较
		*/
	
		String d=""+time.getYear()+""+time.getMonth()+""+time.getDay();
		list=(List<AssetInOut>) hibernateTemplate.find("from AssetInOut where date=? and type=?",new String[]{"'"+d+"'","'"+type+"'"} );
		return list;
	}

	public double assetQueryOut(int year) {
		// TODO Auto-generated method stub
		
		/*根据年份去查询得到该年的支出*/
	/*	要用到模糊查询，由于肯定是2000年以后，所以只有年份才可能匹配，*/
		String ye=Integer.toString(year);
		String hql="from AssetInOut where date=?";
	   
		double d=0;
	list=	(List<AssetInOut>) hibernateTemplate.find(hql, "'"+ye+"%'");//此处模糊查询可能错误
		for(AssetInOut a:list){
			d+=a.getMoney();
		}
	return d;
	}
	
	public BigDecimal assetQueryIn(int year) {
		// TODO Auto-generated method stub
		
		/*根据年份去查询得到该年的收入*/
		
		/* 实现代码处*/
		
		
		return null;
	}

}
