package com.hexdo.hexexamples.model;

import java.io.Serializable;

/**
 * Created by cao_ruixiang on 15/8/14.
 */
public class ResultWrap<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int status;
    private String message;
    private T response;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "ResultWrap{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", response=" + response +
                '}';
    }
}
