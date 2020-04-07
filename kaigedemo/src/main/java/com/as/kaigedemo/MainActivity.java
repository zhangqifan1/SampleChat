package com.as.kaigedemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.as.kaigedemo.bean.BannerBean;
import com.as.kaigedemo.bean.ListBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private String path = "https://dss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2534506313,1688529724&fm=26&gp=0.jpg";
    private String path1 = "https://dss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1208538952,1443328523&fm=26&gp=0.jpg";
    private String path2 = "https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3386247472,87720242&fm=26&gp=0.jpg";


    private String path3 = "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1089874897,1268118658&fm=26&gp=0.jpg";
    private String path4 = "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2892951871,781641693&fm=26&gp=0.jpg";
    private String path5 = "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=160455671,2126788169&fm=26&gp=0.jpg";
    private List<BannerBean> bannerlist, bannerlist2;
    private BannerPageAdapter bannerPageAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private MyAdapter myAdapter;
    private List<ListBean> listBeans2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ViewPager viewPager = findViewById(R.id.viewPager);
        RecyclerView recyclerView = findViewById(R.id.rv);
        swipeRefreshLayout = findViewById(R.id.swipe);

        final BannerBean bannerBean = new BannerBean(path);
        final BannerBean bannerBean1 = new BannerBean(path1);
        final BannerBean bannerBean2 = new BannerBean(path2);

        final BannerBean bannerBean3 = new BannerBean(path3);
        final BannerBean bannerBean4 = new BannerBean(path4);
        final BannerBean bannerBean5 = new BannerBean(path5);

        bannerlist = new ArrayList<BannerBean>() {
            {
                add(bannerBean);
                add(bannerBean1);
                add(bannerBean2);
            }
        };

        bannerlist2 = new ArrayList<BannerBean>() {
            {
                add(bannerBean3);
                add(bannerBean4);
                add(bannerBean5);
            }
        };

        bannerPageAdapter = new BannerPageAdapter();
        bannerPageAdapter.setList(bannerlist);

        viewPager.setAdapter(bannerPageAdapter);
        viewPager.setCurrentItem(0);



        List<ListBean> listBeans=new ArrayList<>();
        listBeans2 = new ArrayList<>();
        ListBean listBean = new ListBean(path);
        ListBean listBean1 = new ListBean(path);
        ListBean listBean2 = new ListBean(path);

        ListBean listBean3 = new ListBean(path);
        ListBean listBean4 = new ListBean(path);
        ListBean listBean5 = new ListBean(path);

        ListBean listBean6 = new ListBean(path);
        ListBean listBean7 = new ListBean(path);
        ListBean listBean8 = new ListBean(path);


        listBeans.add(listBean);
        listBeans.add(listBean1);
        listBeans.add(listBean2);
        listBeans.add(listBean3);
        listBeans.add(listBean4);
        listBeans.add(listBean5);
        listBeans.add(listBean6);
        listBeans.add(listBean7);
        listBeans.add(listBean8);


        ListBean listBean00 = new ListBean(path3);
        ListBean listBean01 = new ListBean(path3);
        ListBean listBean02 = new ListBean(path3);

        ListBean listBean03 = new ListBean(path3);
        ListBean listBean04 = new ListBean(path3);
        ListBean listBean05 = new ListBean(path3);

        ListBean listBean06 = new ListBean(path3);
        ListBean listBean07 = new ListBean(path3);
        ListBean listBean08 = new ListBean(path3);


        listBeans2.add(listBean00);
        listBeans2.add(listBean01);
        listBeans2.add(listBean02);
        listBeans2.add(listBean03);
        listBeans2.add(listBean04);
        listBeans2.add(listBean05);
        listBeans2.add(listBean06);
        listBeans2.add(listBean07);
        listBeans2.add(listBean08);

        myAdapter = new MyAdapter(R.layout.item_rv_image, listBeans);
        GridLayoutManager layoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myAdapter);


        //上拉
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                bannerPageAdapter.setList(bannerlist2);
                bannerPageAdapter.notifyDataSetChanged();

                bannerlist.clear();
                bannerlist.addAll(bannerlist2);
                viewPager.setAdapter(bannerPageAdapter);
                viewPager.setCurrentItem(0);

                myAdapter.setNewData(listBeans2);
                swipeRefreshLayout.setRefreshing(false);
            }
        });


    }
}
