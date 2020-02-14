package com.laywer.interprelaw.model;

public class Law {
    private Integer lawid;

    private Integer cId;

    private String context;

    private String legalprovisions;

    public Integer getLawid() {
        return lawid;
    }

    public void setLawid(Integer lawid) {
        this.lawid = lawid;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    public String getLegalprovisions() {
        return legalprovisions;
    }

    public void setLegalprovisions(String legalprovisions) {
        this.legalprovisions = legalprovisions == null ? null : legalprovisions.trim();
    }
}