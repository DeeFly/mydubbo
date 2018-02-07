package com.gaofei.request;

/**
 * Created by GaoQingming on 2018/2/6 0006.
 */
public class SCRequest extends BaseRequest{
    String order;
    int start = 0;
    int per = 2;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getPer() {
        return per;
    }

    public void setPer(int per) {
        this.per = per;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
