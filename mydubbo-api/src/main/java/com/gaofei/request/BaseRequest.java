package com.gaofei.request;

import java.io.Serializable;

/**
 * Created by GaoQingming on 2018/2/6 0006.
 */
public class BaseRequest implements Serializable {
    //这个地方要指定为""，否则初始值为null
    private String orderBy = "";
    private int page;
    private int perPage;

    public String getOrderBy() {
        if (orderBy == null || orderBy.equals("")) {
            return "";
        }
        return "order by " + orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public void addOrderBy(String column, Order order) {
        if (column == null || column.equals("")) {
            throw new RuntimeException("添加orderBy时必须指定数据库column名！");
        }
        String orderString = order == null ? Order.ASC.order : order.order;
        this.orderBy += column + " " + orderString;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getPageStart() {
        if (page == 0 || perPage == 0) {
            throw new RuntimeException("page 或者 perPage 为0 ，不能分页！");
        }
        return (page - 1) * perPage;
    }

    public String getPaging() {
        if (page == 0 || perPage == 0) {
            return "";
        }
        return "limit " + getPageStart() + ", " + perPage;
    }

    public enum Order {
        ASC("asc"),DESC("desc");
        private String order;

        Order(String order) {
            this.order = order;
        }

        public String getOrder() {
            return this.order;
        }

        public void setOrder(String order) {
            this.order = order;
        }
    }
}
