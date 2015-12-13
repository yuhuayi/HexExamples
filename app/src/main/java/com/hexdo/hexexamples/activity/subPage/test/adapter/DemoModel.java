package com.hexdo.hexexamples.activity.subPage.test.adapter;

/**
 * Created with Android Studio.
 * User: cao_ruixiang
 * Date: 15/10/30
 * Time: 12:07
 */
public class DemoModel {
    public String url;

    public String type;

    public DemoModel(String url, String type) {
        this.url = url;
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
