package com.isep.gitprofiling.model;

public class Comment {

    private String key;

    private String login;

    private String htmlText;

    private String markdown;

    private Boolean updatable;

    private String createdAt;

    public Comment() {
    }

    public Comment(String key, String login, String htmlText, String markdown, Boolean updatable, String createdAt) {
        this.key = key;
        this.login = login;
        this.htmlText = htmlText;
        this.markdown = markdown;
        this.updatable = updatable;
        this.createdAt = createdAt;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHtmlText() {
        return htmlText;
    }

    public void setHtmlText(String htmlText) {
        this.htmlText = htmlText;
    }

    public String getMarkdown() {
        return markdown;
    }

    public void setMarkdown(String markdown) {
        this.markdown = markdown;
    }

    public Boolean getUpdatable() {
        return updatable;
    }

    public void setUpdatable(Boolean updatable) {
        this.updatable = updatable;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
