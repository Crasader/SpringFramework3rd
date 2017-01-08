package com.springframework3rd.domain;


public class Account {
    private final String name;

    public Account(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
