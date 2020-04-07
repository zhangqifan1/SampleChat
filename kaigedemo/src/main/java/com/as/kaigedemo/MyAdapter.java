package com.as.kaigedemo;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.as.kaigedemo.bean.ListBean;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * -----------------------------
 * Created by zqf on 2020/4/2.
 * ---------------------------
 */
public class MyAdapter extends BaseQuickAdapter<ListBean, BaseViewHolder> {


    public MyAdapter(int layoutResId, @Nullable List<ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ListBean item) {

        Glide.with(mContext)
                .load(item.getImagePath())
                .into((ImageView) helper.getView(R.id.item_iv));

    }
}
