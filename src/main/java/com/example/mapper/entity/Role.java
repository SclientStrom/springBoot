package com.example.mapper.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ThinkPad on 2017/7/17.
 */
public class Role {
    private Integer rid;
    private String rname;
    private Set<Module> modules;

    @Override
    public String toString() {
        return "Role{" +
                "rid=" + rid +
                ", rname='" + rname + '\'' +
                ", modules=" + modules +
                '}';
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public Set<Module> getModules() {
        return modules;
    }

    public void setModules(Set<Module> modules) {
        this.modules = modules;
    }
}
