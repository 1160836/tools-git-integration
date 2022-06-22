package com.isep.gitprofiling.model;

public class User {

    private String login;

    private String name;

    private Boolean active;

    private String avatar;

    public User() {
    }

    public User(String login, String name, Boolean active, String avatar) {
        this.login = login;
        this.name = name;
        this.active = active;
        this.avatar = avatar;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
