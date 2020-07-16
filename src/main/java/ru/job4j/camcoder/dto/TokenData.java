package ru.job4j.camcoder.dto;

import java.io.Serializable;

public class TokenData implements Serializable {

    private String value;
    private int ttl;

    public TokenData() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }
}
