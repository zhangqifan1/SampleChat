package com.as.chatkaige.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * -----------------------------
 * Created by zqf on 2020/4/7.
 * ---------------------------
 */
public class MultiBean implements MultiItemEntity {
    public static final int  Type0 = 173;
    public static final int  Type1= 494;

    public int type;

    @Override
    public int getItemType() {
        return type;
    }

    /******************************/
    // 左边用户的 数据
    private String item_text;

    public MultiBean(int type, String item_text) {
        this.type = type;
        this.item_text = item_text;
    }

    public String getItem_text() {
        return item_text;
    }

    public void setItem_text(String item_text) {
        this.item_text = item_text;
    }
}
