package com.isep.gitprofiling.model;

public class AdditionalInfo {

    private Integer intactRows;

    private Float stability;

    private Float age;

    private Float commentsPercentage;

    public AdditionalInfo(Integer intactRows, Float stability, Float age, Float commentsPercentage) {
        this.intactRows = intactRows;
        this.stability = stability;
        this.age = age;
        this.commentsPercentage = commentsPercentage;
    }

    public Integer getIntactRows() {
        return intactRows;
    }

    public void setIntactRows(Integer intactRows) {
        this.intactRows = intactRows;
    }

    public Float getStability() {
        return stability;
    }

    public void setStability(Float stability) {
        this.stability = stability;
    }

    public Float getAge() {
        return age;
    }

    public void setAge(Float age) {
        this.age = age;
    }

    public Float getCommentsPercentage() {
        return commentsPercentage;
    }

    public void setCommentsPercentage(Float commentsPercentage) {
        this.commentsPercentage = commentsPercentage;
    }

    @Override
    public String toString() {
        return "AdditionalInfo{" +
                "intactRows=" + intactRows +
                ", stability=" + stability +
                ", age=" + age +
                ", commentsPercentage=" + commentsPercentage +
                '}';
    }
}
