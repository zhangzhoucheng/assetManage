package com.page.pageDao;

import org.springframework.stereotype.Repository;

import com.page.pageModel.TransactionModel;



/**
 * 分页处理 Dao 类
 * 
 * @author QingShiXun
 * 
 * @version 1.0
 */
@Repository
public class TransactionDao extends AbstractJdbcPagingDao<TransactionModel> {

}
