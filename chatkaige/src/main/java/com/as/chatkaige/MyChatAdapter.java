package com.as.chatkaige;

import com.as.chatkaige.bean.MultiBean;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * -----------------------------
 * Created by zqf on 2020/4/7.
 * ---------------------------
 */
public class MyChatAdapter extends BaseMultiItemQuickAdapter<MultiBean, BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public MyChatAdapter(List<MultiBean> data) {
        super(data);
        addItemType(MultiBean.Type0, R.layout.item_left);
        addItemType(MultiBean.Type1, R.layout.item_right);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultiBean item) {
        int itemType = item.getItemType();

        switch (itemType) {
            // left
            case MultiBean.Type0:
                helper.setText(R.id.tv_left, item.getItem_text());
                break;

            // right
            case MultiBean.Type1:

                helper.setText(R.id.tv_right, item.getItem_text());
                break;
            default:
                break;
        }


    }
}
