package com.as.kaigedemo.bean;

/**
 * -----------------------------
 * Created by zqf on 2020/4/2.
 * ---------------------------
 */
public class BannerBean {
    private String imagePath;

    public BannerBean(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
