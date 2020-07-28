package com.example.copymt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    BottomNavigationBar bottomNavigationBar;

    List<IconInfo> pagerOneData = new ArrayList<>();
    List<IconInfo> pagerTwoData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initViews();

    }

    private void initIconDatas() {

        String[] stringArray = getResources().getStringArray(R.array.icon_name_labels);
        TypedArray typedArray = getResources().obtainTypedArray(R.array.icon);

        for(int i = 0;i<stringArray.length;i++){
            if(i<15){
                IconInfo iconInfo = new IconInfo(stringArray[i],typedArray.getResourceId(i,0));
                pagerOneData.add(iconInfo);
            }else{
                IconInfo iconInfo = new IconInfo(stringArray[i],typedArray.getResourceId(i,0));
                pagerTwoData.add(iconInfo);
            }
        }

    }

    private void initViews() {
        //隐藏软键盘
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        //沉浸式
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().setStatusBarColor(getResources().getColor(R.color.mainColor));


        initBanner();
        initIconDatas();
        initGridView();
        initPopWindow();
        initBottomNavigationBar();
    }

    private void initPopWindow() {

    }

    private void initBanner() {

        List<Integer> images = new ArrayList<>();
        images.add(R.mipmap.pa);
        images.add(R.mipmap.pb);
        images.add(R.mipmap.pc);
        images.add(R.mipmap.pd);
        images.add(R.mipmap.pe);
        images.add(R.mipmap.pf);

        Banner banner = findViewById(R.id.banner);
        //右下方圆点
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .setImageLoader(new GlideImageLoader())
                .setBannerAnimation(Transformer.Default)
                .setImages(images)
                .isAutoPlay(true)
                .setIndicatorGravity(BannerConfig.RIGHT)
                .setDelayTime(4000);

        banner.start();
    }

    private void initGridView() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View pageOne = inflater.inflate(R.layout.home_gridview,null);
        GridView gridViewOne = pageOne.findViewById(R.id.iconGv);
        gridViewOne.setAdapter(new GridViewAdapter(pagerOneData,this));
        gridViewOne.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });


        View pageTwo = inflater.inflate(R.layout.home_gridview,null);
        GridView gridViewTwo = pageTwo.findViewById(R.id.iconGv);
        gridViewTwo.setAdapter(new GridViewAdapter(pagerTwoData,this));
        gridViewTwo.setOnItemClickListener((parent, view, position, id) -> {
        });


        List<View> views = new ArrayList<>();
        views.add(pageOne);
        views.add(pageTwo);
        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyPagerAdapter(views));



    }

    private void initBottomNavigationBar() {
        bottomNavigationBar = findViewById(R.id.bottomNavigationBar);

        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);

        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.mipmap.meituan,"首页").setInactiveIconResource(R.mipmap.shouye))
                .addItem(new BottomNavigationItem(R.mipmap.faxian,"发现"))
                .addItem(new BottomNavigationItem(R.mipmap.dingdan,"订单"))
                .addItem(new BottomNavigationItem(R.mipmap.my,"我的"))
                .setActiveColor("#FFD700")
                .setFirstSelectedPosition(0)
                .initialise();

        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {

            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }

}
