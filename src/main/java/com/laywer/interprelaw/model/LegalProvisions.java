package com.laywer.interprelaw.model;

public class LegalProvisions {
    private Integer id;

    private String label;

    private String legalprovisions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    public String getLegalprovisions() {
        return legalprovisions;
    }

    public void setLegalprovisions(String legalprovisions) {
        this.legalprovisions = legalprovisions == null ? null : legalprovisions.trim();
    }

    @Override
    public String toString() {
        return "LegalProvisions{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", legalprovisions='" + legalprovisions + '\'' +
                '}';
    }
}