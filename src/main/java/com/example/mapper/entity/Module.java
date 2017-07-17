package com.example.mapper.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ThinkPad on 2017/7/17.
 */
public class Module {
    private Integer mid;
    private String mname;

    @Override
    public String toString() {
        return "Module{" +
                "mid=" + mid +
                ", mname='" + mname + '\'' +
                '}';
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }
}
