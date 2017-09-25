package com.joke2017.smile2017.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.gyf.barlibrary.ImmersionBar;
import com.joke2017.smile2017.R;
import com.umeng.analytics.MobclickAgent;
import com.zhy.autolayout.AutoLayoutActivity;


public abstract class BaseActivity extends AutoLayoutActivity {
    private ImmersionBar mImmersionBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MobclickAgent.openActivityDurationTrack(false);// 禁止默认的页面统计方式，这样将不会再自动统计Activity。
        initTitleView();
    }

    /*给系统状态栏进行着色*/
    protected void initTitleView() {
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.statusBarColor(R.color.black);
        mImmersionBar.init();   //所有子类都将继承这些相同的属性
    }

    /*初始化控件*/
    protected abstract void initView();

    /*初始化监听器*/
    protected abstract void initListener();

    /*初始化数据*/
    protected void initData() {

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mImmersionBar != null)
            mImmersionBar.destroy();  //必须调用该方法，防止内存泄漏，不调用该方法，如果界面bar发生改变，在不关闭app的情况下，退出此界面再进入将记忆最后一次bar改变的状态
    }
    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onPageStart("BaseActivity"); // [统计页面(仅有Activity的应用中SDK自动调用,不需要单独写。参数为页面名称,可自定义)]
        MobclickAgent.onResume(this);// 友盟统计，所有Activity中添加，父类添加后子类不用重复添加
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd("BaseActivity"); // [(仅有Activity的应用中SDK自动调用,不需要单独写)保证onPageEnd在onPause之前调用,因为onPause中会保存信息。参数页面名称,可自定义]
        MobclickAgent.onPause(this);// 友盟统计，所有Activity中添加，父类添加后子类不用重复添加
    }


}
