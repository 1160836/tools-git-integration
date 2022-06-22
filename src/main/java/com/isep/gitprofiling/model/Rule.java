package com.isep.gitprofiling.model;

public class Rule {

    private String key;

    private String name;

    private String status;

    private String lang;

    private String langName;

    public Rule() {
    }

    public Rule(String key, String name, String status, String lang, String langName) {
        this.key = key;
        this.name = name;
        this.status = status;
        this.lang = lang;
        this.langName = langName;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getLangName() {
        return langName;
    }

    public void setLangName(String langName) {
        this.langName = langName;
    }
}
