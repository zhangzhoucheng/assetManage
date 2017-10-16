/*****************************************************************************
 * Copyright (c) 2015, www.qingshixun.com
 *
 * All rights reserved
 *
 *****************************************************************************/
package com.page.pageTagActiveClass;

/**
 * 自定义分页标签类
 * 
 * @author QingShiXun
 * 
 * @version 1.0
 */
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class PagingTag extends TagSupport {

    private static final long serialVersionUID = 5729832874890369508L;

    private String url; // 请求Url

    private int pageSize; // 每页要显示的记录数

    private int pageNo = 1; // 当前页号

    private int totalCount; // 总记录数

    public int doStartTag() throws JspException {
        int pageCount = (totalCount + pageSize - 1) / pageSize; // 计算总页数
        // 拼写要输出到页面的HTML文本
        StringBuilder sb = new StringBuilder();
        sb.append("<div class=\"default-paging\">\r\n");
        if (totalCount == 0) {
            sb.append("<strong>没有可显示的项目</strong>\r\n");
        } else {
            // 页号越界处理
            if (pageNo > pageCount) {
                pageNo = pageCount;
            }
            if (pageNo < 1) {
                pageNo = 1;
            }

            sb.append("<form method=\"get\" action=\"").append(this.url).append("\" name=\"pagingForm\">\r\n");

            // 获取请求中的所有参数
            HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
            Enumeration<String> enumeration = request.getParameterNames();
            String name = null; // 参数名
            String value = null; // 参数值

            // 把请求中的所有参数当作隐藏表单域
            while (enumeration.hasMoreElements()) {
                name = enumeration.nextElement();
                value = request.getParameter(name);
                // 去除页号
                if (name.equals("pageNo")) {
                    if (null != value && !"".equals(value)) {
                        pageNo = Integer.parseInt(value);
                    }
                    continue;
                }
                sb.append("<input type=\"hidden\" name=\"").append(name).append("\" value=\"").append(value).append("\"/>\r\n");
            }

            // 把当前页号设置成请求参数
            sb.append("<input type=\"hidden\" name=\"").append("pageNo").append("\" value=\"").append(pageNo).append("\"/>\r\n");

            // 输出统计数据
            sb.append("&nbsp;共: <strong>").append(pageCount).append("</strong> 页").append(", <strong>").append(totalCount).append("</strong> 条记录 &nbsp;\r\n");

            // 上一页处理
            if (pageNo == 1) {
                sb.append("<span class=\"disabled\">&laquo;&nbsp;上一页").append("</span>\r\n");
            } else {
                sb.append("<a href=\"javascript:changePage(").append((pageNo - 1)).append(")\">&laquo;&nbsp;上一页</a>\r\n");
            }

            // 如果前面页数过多,显示"..."
            int start = 1;
            if (this.pageNo > 4) {
                start = this.pageNo - 1;
                sb.append("<a href=\"javascript:changePage(1)\">1</a>\r\n");
                sb.append("<a href=\"javascript:changePage(2)\">2</a>\r\n");
                sb.append("&hellip;\r\n");
            }

            // 显示当前页附近的页
            int end = this.pageNo + 1;
            if (end > pageCount) {
                end = pageCount;
            }
            for (int i = start; i <= end; i++) {
                if (pageNo == i) { // 当前页号不需要超链接
                    sb.append("<span class=\"current\">").append(i).append("</span>\r\n");
                } else {
                    sb.append("<a href=\"javascript:changePage(").append(i).append(")\">").append(i).append("</a>\r\n");
                }
            }
            // 如果后面页数过多,显示"..."
            if (end < pageCount - 2) {
                sb.append("&hellip;\r\n");
            }
            if (end < pageCount - 1) {
                sb.append("<a href=\"javascript:changePage(").append(pageCount - 1).append(")\">").append(pageCount - 1).append("</a>\r\n");
            }
            if (end < pageCount) {
                sb.append("<a href=\"javascript:changePage(").append(pageCount).append(")\">").append(pageCount).append("</a>\r\n");
            }

            // 下一页处理
            if (pageNo == pageCount) {
                sb.append("<span class=\"disabled\">下一页&nbsp;&raquo;").append("</span>\r\n");
            } else {
                sb.append("<a href=\"javascript:changePage(").append((pageNo + 1)).append(")\">下一页&nbsp;&raquo;</a>\r\n");
            }
            sb.append("</form>\r\n");

            // 生成提交表单的JavaScript
            sb.append("<script language=\"javascript\">\r\n");
            sb.append("  function changePage(no){\r\n");
            sb.append("    if(no>").append(pageCount).append("){");
            sb.append("      no=").append(pageCount).append(";}\r\n");
            sb.append("    if(no<1){no=1;}\r\n");
            sb.append("    document.pagingForm.pageNo.value=no;\r\n");
            sb.append("    document.pagingForm.submit();\r\n");
            sb.append("  }\r\n");
            sb.append("</script>\r\n");
        }
        sb.append("</div>\r\n");

        // 把生成的HTML输出到响应中
        try {
            pageContext.getOut().println(sb.toString());
        } catch (IOException e) {
            throw new JspException(e);
        }

        // 本标签主体为空,所以直接跳过主体
        return SKIP_BODY;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
