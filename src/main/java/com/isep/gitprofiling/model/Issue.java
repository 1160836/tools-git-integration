package com.isep.gitprofiling.model;

import java.util.List;

public class Issue {

    private Paging paging;

    private List<IssueDescription> issues;

    private List<Component> components;

    private List<Rule> rules;

    private List<User> users;

    public Issue() {
    }

    public Issue(Paging paging, List<IssueDescription> issues, List<Component> components, List<Rule> rules, List<User> users) {
        this.paging = paging;
        this.issues = issues;
        this.components = components;
        this.rules = rules;
        this.users = users;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

    public List<IssueDescription> getIssues() {
        return issues;
    }

    public void setIssues(List<IssueDescription> issues) {
        this.issues = issues;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
