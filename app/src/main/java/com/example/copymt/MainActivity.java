package com.example.copymt;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

public class MainActivity extends AppCompatActivity {

    BottomNavigationBar bottomNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        initViews();


    }

    private void initViews() {
        initStutas();
        initBottomNavigationBar();
    }

    private void initStutas() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            findViewById(android.R.id.content).setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }
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
