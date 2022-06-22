package com.isep.gitprofiling.model;


public class MetricDescription {

    private String id;

    private String key;

    private String name;

    private String description;

    private String domain;

    private String type;

    private String direction;

    private Boolean qualitative;

    private Boolean hidden;

    private Boolean custom;

    private Boolean higherValuesAreBetter;

    public MetricDescription(){}

    public MetricDescription(String id, String key, String name, String description, String domain, String type, String direction, Boolean qualitative, Boolean hidden, Boolean custom, Boolean higherValuesAreBetter) {
        this.id = id;
        this.key = key;
        this.name = name;
        this.description = description;
        this.domain = domain;
        this.type = type;
        this.direction = direction;
        this.qualitative = qualitative;
        this.hidden = hidden;
        this.custom = custom;
        this.higherValuesAreBetter = higherValuesAreBetter;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Boolean getQualitative() {
        return qualitative;
    }

    public void setQualitative(Boolean qualitative) {
        this.qualitative = qualitative;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public Boolean getCustom() {
        return custom;
    }

    public void setCustom(Boolean custom) {
        this.custom = custom;
    }

    public Boolean getHigherValuesAreBetter() {
        return higherValuesAreBetter;
    }

    public void setHigherValuesAreBetter(Boolean higherValuesAreBetter) {
        this.higherValuesAreBetter = higherValuesAreBetter;
    }
}
