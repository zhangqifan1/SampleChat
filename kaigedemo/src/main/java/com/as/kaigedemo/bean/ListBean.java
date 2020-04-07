package com.as.kaigedemo.bean;

import java.util.List;

/**
 * -----------------------------
 * Created by zqf on 2020/4/2.
 * ---------------------------
 */
public class ListBean {
    private String imagePath;

    public ListBean(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
