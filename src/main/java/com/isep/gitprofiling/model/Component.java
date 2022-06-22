package com.isep.gitprofiling.model;

import java.util.List;

public class Component {

    private String key;

    private Boolean enabled;

    private String qualifier;

    private String name;

    private String longName;

    private String path;


    private String language;

    private List<MeasureDescription> measures;

    private Component(){

    }

    public Component(String key, Boolean enabled, String qualifier, String name, String longName, String path, String language, List<MeasureDescription> measures) {
        this.key = key;
        this.enabled = enabled;
        this.qualifier = qualifier;
        this.name = name;
        this.longName = longName;
        this.path = path;
        this.language = language;
        this.measures = measures;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getQualifier() {
        return qualifier;
    }

    public void setQualifier(String qualifier) {
        this.qualifier = qualifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<MeasureDescription> getMeasures() {
        return measures;
    }

    public void setMeasures(List<MeasureDescription> measures) {
        this.measures = measures;
    }
}
