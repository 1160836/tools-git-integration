package com.isep.gitprofiling.model;

public class MeasureDescription {

    private String metric;

    private String value;

    private Period period;


    public MeasureDescription() {
    }

    public MeasureDescription(String metric, String value, Period period) {
        this.metric = metric;
        this.value = value;
        this.period = period;
    }

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }
}
