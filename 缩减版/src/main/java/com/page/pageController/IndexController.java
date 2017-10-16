/*****************************************************************************
 * Copyright (c) 2015, www.qingshixun.com
 *
 * All rights reserved
 *
 *****************************************************************************/

package com.page.pageController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.page.pageModel.Page;
import com.page.pageModel.TransactionModel;
import com.page.pageService.TransactionJdbcService;


/**
 * 列表处理 Controller 类
 * 
 * @author QingShiXun
 * 
 * @version 1.0
 */
@Controller

public class IndexController extends BaseController {

    @Autowired
    private TransactionJdbcService transactionJdbctervice;

    // 指定默认每页的显示记录条数
    private static final int DEFAULT_PAGE_SIZE = 5;

    // 分页显示的列表数据

    public String index(Model model, HttpServletRequest request) {
        int pageNo = 1;

        //指定页数（第几页）
        String inputPageNo = request.getParameter("pageNo");
        if (!StringUtils.isEmpty(inputPageNo)) {
            pageNo = Integer.parseInt(inputPageNo);
        }

        //查询并返回分页数据
        Page<TransactionModel> transaction = transactionJdbctervice.findTransactionList(pageNo, DEFAULT_PAGE_SIZE);

        model.addAttribute("transaction", transaction);
        return "index";
    }
}
