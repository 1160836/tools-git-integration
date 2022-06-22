package com.isep.gitprofiling.model;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class Metric {

    private int total;

    private int p;

    private int ps;
    private List<MetricDescription> metrics;

    public Metric(){}

    public Metric(int total, int p, int ps, List<MetricDescription> metrics) {
        this.total = total;
        this.p = p;
        this.ps = ps;
        this.metrics = metrics;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public int getPs() {
        return ps;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }

    public List<MetricDescription> getMetrics() {
        return metrics;
    }

    public void setMetrics(List<MetricDescription> metrics) {
        this.metrics = metrics;
    }

    @Override
    public String toString() {
        return "Metric{" +
                "total=" + total +
                ", p=" + p +
                ", ps=" + ps +
                ", metrics=" + metrics +
                '}';
    }
}
