package com.laywer.interprelaw.model;

import java.util.ArrayList;
import java.util.List;

public class MenuTree {
    private Integer id;

    private String authname;

    private Integer pid;

    private Integer levels;

    private List children = new ArrayList();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthname() {
        return authname;
    }

    public void setAuthname(String authname) {
        this.authname = authname == null ? null : authname.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getLevels() {
        return levels;
    }

    public void setLevels(Integer levels) {
        this.levels = levels;
    }

    public List getChildren() {
        return children;
    }

    public void setChildren(List children) {
        this.children = children;
    }

    public MenuTree(Integer id, String authname) {
        this.id = id;
        this.authname = authname;
    }

    public MenuTree(Integer id, String authname, Integer pid) {
        this.id = id;
        this.authname = authname;
        this.pid = pid;
    }

    public MenuTree() {
        super();
    }

    public MenuTree(Integer id, String authname, Integer pid, List children) {
        super();
        this.id = id;
        this.authname = authname;
        this.pid = pid;
        this.children = children;
    }

    @Override
    public String toString() {
        return "MenuTree{" +
                "id=" + id +
                ", authname='" + authname + '\'' +
                ", pid=" + pid +
                ", levels=" + levels +
                ", children=" + children +
                '}';
    }
}