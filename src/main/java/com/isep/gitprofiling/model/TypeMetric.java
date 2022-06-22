package com.isep.gitprofiling.model;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class TypeMetric {

    private List<String> types;

    public TypeMetric(){}

    public TypeMetric(List<String> types) {
        this.types = types;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    @Override
    public String toString() {
        return "TypeMetric{" +
                "types=" + types +
                '}';
    }
}
