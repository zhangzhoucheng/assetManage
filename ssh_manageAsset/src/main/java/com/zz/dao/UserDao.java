package com.zz.dao;




import javax.annotation.Resource;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
/*import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;*/
import org.springframework.stereotype.Repository;





@Repository(value="ud")
public class UserDao  /*extends HibernateDaoSupport*/{
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

		/***
		 * dao层实现查询数据信息，判断用户登录是否成功
		 * @return
		 */
		public int checkUser() {
			// TODO Auto-generated method stub
			 int key=0;
			/* 实现代码处*/
			
			return key;
		}

		/***
		 * dao层实现的插入操作，在插入时候，先验证用户存在不，在插入，根据情况返回int
		 * @return
		 */
		public int insertUser() {
			// TODO Auto-generated method stub
			 int key=0;
			
			/* 实现代码处*/
			
	    	 return key;
		}
		
}
