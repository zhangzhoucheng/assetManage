/*****************************************************************************
 * Copyright (c) 2015, www.qingshixun.com
 *
 * All rights reserved
 *
 *****************************************************************************/
package com.page.pageService;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.page.pageDao.TransactionDao;
import com.page.pageModel.Page;
import com.page.pageModel.TransactionModel;


/**
 * 分页查询Service 类
 * 
 * @author QingShiXun
 * 
 * @version 1.0
 */
@Service
public class TransactionJdbcService extends AbstractJdbcService {

    @Autowired
    private TransactionDao transactionDao;

    //查询数据记录总数SQL
    private static String QUERY_TRANS_COUNT_SQL = "select count(*) from zz_transaction  ";

    //查询数据记录SQL
    private static String QUERY_TRANS_DATA_SQL = "select * from zz_transaction ";

    //分页查询列表
    public Page<TransactionModel> findTransactionList(int pageNo, int pageSize) {
        Object[] args = null;
        return transactionDao.getPages(QUERY_TRANS_COUNT_SQL, QUERY_TRANS_DATA_SQL, args, pageNo, pageSize, new TransactionRowMap());
    }

    //将数据封装成TransactionModel实体
    class TransactionRowMap implements RowMapper<TransactionModel> {

        @Override
        public TransactionModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            TransactionModel transaction = new TransactionModel();
            transaction.setId(rs.getLong("id"));
            transaction.setAmount(rs.getDouble("amount"));
            transaction.setMonth(rs.getInt("month"));
            transaction.setRegion(rs.getString("region"));
            return transaction;
        }
    }
}
