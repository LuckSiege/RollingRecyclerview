package com.luck.rollingrecyclerview;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LinearLayout llSearch;
    private HomeAdapter adapter;
    private int height = 640;// 滑动开始变色的高,真实项目中此高度是由广告轮播或其他首页view高度决定
    private int overallXScroll = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        llSearch = (LinearLayout) findViewById(R.id.ll_search);
        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new RecycleViewDivider(
                MainActivity.this, LinearLayoutManager.HORIZONTAL, Utils.dip2px(MainActivity.this, 0.5f), ContextCompat.getColor(MainActivity.this, R.color.line_color)));
        recyclerView.setLayoutManager(manager);

        adapter = new HomeAdapter(this);

        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                overallXScroll = overallXScroll + dy;// 累加y值 解决滑动一半y值为0
                if (overallXScroll <= 0) {   //设置标题的背景颜色
                    llSearch.setBackgroundColor(Color.argb((int) 0, 41, 193, 246));
                } else if (overallXScroll > 0 && overallXScroll <= height) { //滑动距离小于banner图的高度时，设置背景和字体颜色颜色透明度渐变
                    float scale = (float) overallXScroll / height;
                    float alpha = (255 * scale);
                    llSearch.setBackgroundColor(Color.argb((int) alpha, 41, 193, 246));
                } else {
                    llSearch.setBackgroundColor(Color.argb((int) 255, 41, 193, 246));
                }
            }
        });
    }
}
