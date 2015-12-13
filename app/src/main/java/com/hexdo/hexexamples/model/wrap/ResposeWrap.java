package com.hexdo.hexexamples.model.wrap;

import java.io.Serializable;

/**
 * Created by cao_ruixiang on 15/8/14.
 */
public class ResposeWrap<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private T userInfo;

    public T getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(T userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "ResposeWrap{" +
                "userInfo=" + userInfo +
                '}';
    }
}
