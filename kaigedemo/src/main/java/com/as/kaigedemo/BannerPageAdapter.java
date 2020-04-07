package com.as.kaigedemo;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.viewpager.widget.PagerAdapter;

import com.as.kaigedemo.bean.BannerBean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

/**
 * 推荐视频 改为左右滑动
 */
public class BannerPageAdapter extends PagerAdapter {

    private List<BannerBean> list;

    public BannerPageAdapter() {
    }

    public void setList(List<BannerBean> list) {
        this.list = list;
    }

    @NonNull
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        BannerBean bannerBean = list.get(position);

        Context context = container.getContext();

        View inflate = View.inflate(context, R.layout.item_banner_iv, null);
        ImageView iv_banner = inflate.findViewById(R.id.iv_banner);
        Glide.with(context)
                .load(bannerBean.getImagePath())
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(10)))
                .into(iv_banner);

        container.addView(inflate);
        return inflate;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(((View) object));
    }


}