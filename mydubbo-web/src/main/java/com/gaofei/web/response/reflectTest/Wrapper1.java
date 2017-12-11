package com.gaofei.web.response.reflectTest;

/**
 * Created by GaoQingming on 2017/11/16 0016.
 */
public class Wrapper1 {
    private String diff1;
    private String same;

    public String getDiff1() {
        return diff1;
    }

    public void setDiff1(String diff1) {
        this.diff1 = diff1;
    }

    public String getSame() {
        return same;
    }

    public void setSame(String same) {
        this.same = same;
    }

    @Override
    public String toString() {
        return "Wrapper1{" +
                "diff1='" + diff1 + '\'' +
                ", same='" + same + '\'' +
                '}';
    }
}
