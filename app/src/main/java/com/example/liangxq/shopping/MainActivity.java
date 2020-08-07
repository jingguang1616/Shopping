package com.example.liangxq.shopping;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.mvplibrary.base.BaseActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {


    @BindView(R.id.fl)
    FrameLayout fl;
    @BindView(R.id.bnb)
    BottomNavigationBar bnb;
    private FragmentTransaction transaction;
    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private Fragment3 fragment3;
    private Fragment4 fragment4;
    private Fragment5 fragment5;
    private Fragment mFragment;
    private android.app.FragmentTransaction fragmentTransaction;
    private FragmentManager manager;


    @Override
    protected void initEvent() {
        initBottomNavigationBar();
        //mor导航栏
        fragment();
    }

    private void initBottomNavigationBar() {
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();
        fragment5 = new Fragment5();
        manager = getSupportFragmentManager();
        manager.beginTransaction().add(R.id.fl,fragment1).add(R.id.fl,fragment2).add(R.id.fl,fragment3).add(R.id.fl,fragment4).add(R.id.fl,fragment5)
                    .show(fragment1).hide(fragment2).hide(fragment3).hide(fragment4).hide(fragment5).commit();
        mFragment=fragment1;

        //统一设置点击颜色
        bnb.setActiveColor(R.color.colorPrimary);
        //统一设置未点击颜色
        bnb.setInActiveColor(R.color.colorhei);
        //统一设置BottomNavigationBar的背景色
        bnb.setBarBackgroundColor(R.color.colorbai);
        //设置BottomNavigationBar的模式
        bnb.setMode(BottomNavigationBar.MODE_FIXED);
        //设置背景样式
        bnb.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        //生成BottomNavigationBar中的每一个item
        BottomNavigationItem item1 = new BottomNavigationItem(R.drawable.fragment1, "主页");
        BottomNavigationItem item2 = new BottomNavigationItem(R.drawable.fragment2, "分类");
        BottomNavigationItem item3 = new BottomNavigationItem(R.drawable.fragment3, "购物车");
        BottomNavigationItem item4 = new BottomNavigationItem(R.drawable.fragment4, "消息");
        BottomNavigationItem item5 = new BottomNavigationItem(R.drawable.fragment5, "我的");
        //将item添加到BottomNavigationBar中
        bnb.addItem(item1);
        bnb.addItem(item2);
        bnb.addItem(item3);
        bnb.addItem(item4);
        bnb.addItem(item5);
        bnb.setFirstSelectedPosition(0);
        bnb.initialise();
        bnb.setTabSelectedListener(this);
    }

    private void fragment() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int initLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public void onTabSelected(int position) {
        new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                if (position==0){
                    manager.beginTransaction().show(fragment1).hide(fragment2).hide(fragment3).hide(fragment4).hide(fragment5).commit();
                }else if (position==1){
                    manager.beginTransaction().show(fragment2).hide(fragment1).hide(fragment3).hide(fragment4).hide(fragment5).commit();
                }else if (position==2){
                    manager.beginTransaction().show(fragment3).hide(fragment2).hide(fragment1).hide(fragment4).hide(fragment5).commit();
                }else if (position==3){
                    manager.beginTransaction().show(fragment4).hide(fragment2).hide(fragment3).hide(fragment1).hide(fragment5).commit();
                }else if (position==4){
                    manager.beginTransaction().show(fragment5).hide(fragment2).hide(fragment3).hide(fragment4).hide(fragment1).commit();
                }
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        };
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
