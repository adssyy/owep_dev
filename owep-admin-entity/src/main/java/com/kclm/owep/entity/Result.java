package com.kclm.owep.entity;

import java.util.Objects;

public class Result {

    private String status;

    private Object data;

    public Result() {
    }

    public Result(String ststus, Object data) {
        this.status = ststus;
        this.data = data;
    }

    public String getStstus() {
        return status;
    }

    public void setStstus(String ststus) {
        this.status = ststus;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Result{");
        sb.append("status='").append(status).append('\'');
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return Objects.equals(status, result.status) &&
                Objects.equals(data, result.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, data);
    }
}

