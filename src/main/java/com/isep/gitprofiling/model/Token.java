package com.isep.gitprofiling.model;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Token {

    private String login;

    private String name;

    private String createdAt;

    private String token;

    public Token(String name) {
        this.name = name;
    }

    public Token(String login, String name, String createdAt, String token) {
        this.login = login;
        this.name = name;
        this.createdAt = createdAt;
        this.token = token;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Token{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
