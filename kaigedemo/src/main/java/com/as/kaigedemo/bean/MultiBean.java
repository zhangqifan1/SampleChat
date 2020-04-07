package com.as.kaigedemo.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * -----------------------------
 * Created by zqf on 2020/4/2.
 * ---------------------------
 */
public class MultiBean implements MultiItemEntity {

    public static final int Type0 = 51653;
    public static final int Type1 = 11145;

    public int TYPE;

    @Override
    public int getItemType() {
        return TYPE;
    }

    /****************Type0**************/
    private BannerBean bannerBean;

    public MultiBean(int TYPE, BannerBean bannerBean) {
        this.TYPE = TYPE;
        this.bannerBean = bannerBean;
    }

    /****************Type1**************/
    private ListBean listBean;

    public MultiBean(int TYPE, ListBean listBean) {
        this.TYPE = TYPE;
        this.listBean = listBean;
    }


    /************ set  get********/
    public int getTYPE() {
        return TYPE;
    }

    public void setTYPE(int TYPE) {
        this.TYPE = TYPE;
    }

    public BannerBean getBannerBean() {
        return bannerBean;
    }

    public void setBannerBean(BannerBean bannerBean) {
        this.bannerBean = bannerBean;
    }

    public ListBean getListBean() {
        return listBean;
    }

    public void setListBean(ListBean listBean) {
        this.listBean = listBean;
    }
}
