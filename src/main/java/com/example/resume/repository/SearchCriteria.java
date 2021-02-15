package com.example.resume.repository;

public class SearchCriteria {
    public SearchCriteria(String key, String operation, Object value) {
        this.key = key;
        this.operation = operation;
        this.value = value;

    }

    private String key;
    private Boolean orPredicate = false;

    public Boolean getOrPredicate() {
        return orPredicate;
    }

    public void setOrPredicate(Boolean orPredicate) {
        this.orPredicate = orPredicate;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    private String operation;
    private Object value;

    public boolean isOrPredicate() {
        if(orPredicate)
            return true;
        else return false;
    }
}