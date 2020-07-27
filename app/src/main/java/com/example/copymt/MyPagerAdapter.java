package com.example.copymt;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MyPagerAdapter extends PagerAdapter {

    private List<View> views = new ArrayList<>();

    public MyPagerAdapter(List<View> views) {
        this.views = views;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = views.get(position);
        if(position == 1){
            ImageView firstImage = view.findViewById(R.id.first_page_icon);
            ImageView secondImage = view.findViewById(R.id.second_page_icon);
            Glide.with(view).load(R.mipmap.huidian).into(firstImage);
            Glide.with(view).load(R.mipmap.huangdian).into(secondImage);
        }
        int childViewHeight = container.getHeight();
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, childViewHeight );//这里设置params的高度。
        container.removeView(view);
        container.addView(view, position , params);//使用这个params
//        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
    }

    @Override
    public int getCount() { return views.size(); }

    @Override
    public boolean isViewFromObject(View view, Object object) { return view == object; }

}
