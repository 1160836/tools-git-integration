package com.isep.gitprofiling.model;

import java.util.List;

public class Measure {

    private Component component;

    private List<MetricDescription> metrics;


    public Measure(){

    }

    public Measure(Component component, List<MetricDescription> metrics) {
        this.component = component;
        this.metrics = metrics;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public List<MetricDescription> getMetrics() {
        return metrics;
    }

    public void setMetrics(List<MetricDescription> metrics) {
        this.metrics = metrics;
    }

    @Override
    public String toString() {
        return "Measure{" +
                "component=" + component +
                ", metrics=" + metrics +
                '}';
    }
}
