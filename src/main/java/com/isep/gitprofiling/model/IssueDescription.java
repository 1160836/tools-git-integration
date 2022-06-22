package com.isep.gitprofiling.model;

import java.util.List;

public class IssueDescription {

    private String key;

    private String component;

    private String project;

    private String rule;

    private String status;

    private String resolution;

    private String severity;

    private String message;

    private int line;

    private String hash;

    private String author;

    private String effort;

    private String creationDate;

    private String updateDate;

    private List<String> tags;

    private String type;

    private List<Comment> comments;

    public IssueDescription(){

    }

    public IssueDescription(String key, String component, String project, String rule, String status, String resolution, String severity, String message, int line, String hash, String author, String effort, String creationDate, String updateDate, List<String> tags, String type, List<Comment> comments) {
        this.key = key;
        this.component = component;
        this.project = project;
        this.rule = rule;
        this.status = status;
        this.resolution = resolution;
        this.severity = severity;
        this.message = message;
        this.line = line;
        this.hash = hash;
        this.author = author;
        this.effort = effort;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.tags = tags;
        this.type = type;
        this.comments = comments;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEffort() {
        return effort;
    }

    public void setEffort(String effort) {
        this.effort = effort;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
