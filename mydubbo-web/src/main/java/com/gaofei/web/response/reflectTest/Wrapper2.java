package com.gaofei.web.response.reflectTest;

/**
 * Created by GaoQingming on 2017/11/16 0016.
 */
public class Wrapper2 {
    private String diff2;
    private String same;

    public String getDiff2() {
        return diff2;
    }

    @Override
    public String toString() {
        return "Wrapper2{" +
                "diff2='" + diff2 + '\'' +
                ", same='" + same + '\'' +
                '}';
    }

    public void setDiff2(String diff2) {
        this.diff2 = diff2;
    }

    public String getSame() {
        return same;
    }

    public void setSame(String same) {
        this.same = same;
    }
}
