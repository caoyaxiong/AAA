package com.joke2017.smile2017.activity;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.baidu.mobads.AdSettings;
import com.baidu.mobads.AdView;
import com.baidu.mobads.AdViewListener;
import com.baidu.mobads.AppActivity;
import com.bumptech.glide.Glide;
import com.gyf.barlibrary.ImmersionBar;
import com.joke2017.smile2017.R;
import com.joke2017.smile2017.base.BaseActivity;
import com.joke2017.smile2017.http.Constants;
import com.qq.e.ads.banner.ADSize;
import com.qq.e.ads.banner.AbstractBannerADListener;
import com.qq.e.ads.banner.BannerView;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import org.json.JSONObject;

public class DetailPageActivity extends BaseActivity implements View.OnClickListener {

    private LinearLayout mDetailPageBack;
    private com.tencent.smtt.sdk.WebView mTencentWebView;
    private ImmersionBar mImmersionBar;
    private RelativeLayout banner_browser;
    private ImageView remove_browser;
    private String url;
    private int num;
    AdView adView;
    BannerView bv;
    private ImageView back;
    private ImageView loading;
    private String search_url;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        Intent intent = getIntent();
        num = SplashActivity.num;
        url = intent.getStringExtra("url");
        search_url = getIntent().getStringExtra("search_url");
        initView();
        if (search_url != null) {
            loadUrl(search_url);
        } else {
            loadUrl(url);
        }
        initListener();
    }


    private void loadUrl(String url) {
        WebSettings webSettings = mTencentWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mTencentWebView.loadUrl(url);
        mTencentWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView webView, String url) {
                webView.loadUrl(url);
                return true;
            }

            @Override
            public void onPageStarted(WebView webView, String s, Bitmap bitmap) {
                super.onPageStarted(webView, s, bitmap);
                //设置跳转详情页正在加载loading
                Glide.with(DetailPageActivity.this).load(R.drawable.loading).into(loading);
            }

            @Override
            public void onPageFinished(WebView webView, String url) {
                super.onPageFinished(webView, url);
                Glide.clear(loading);
                loading.setVisibility(View.GONE);
                if (num == 0) {

                } else if (num == 1) {
                    initBaiDuBanner();
                } else if (num == 2) {
                    initGDTBanner();
                }
            }
        });

    }

    @Override
    protected void initView() {
        banner_browser = (RelativeLayout) findViewById(R.id.banner_browser);
        remove_browser = (ImageView) findViewById(R.id.remove_browser);
        mDetailPageBack = (LinearLayout) findViewById(R.id.detail_page_back);
        back = (ImageView) findViewById(R.id.iv_back);
        loading = (ImageView) findViewById(R.id.loading);
        mTencentWebView = (com.tencent.smtt.sdk.WebView)
                findViewById(R.id.tencent_web_view);
    }

    @Override
    protected void initListener() {
        back.setOnClickListener(this);
        remove_browser.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
//                if (mTencentWebView != null && mTencentWebView.canGoBack()) {
//                    mTencentWebView.goBack();
//                } else {
//                    finish();
//                }
                finish();
                break;
            case R.id.remove_browser:
                banner_browser.removeAllViews();
                if (num == 1) {
                    adView.destroy();
                } else if (num == 2) {
                    if (bv != null) {
                        bv.destroy();
                        bv = null;
                    }
                }
                banner_browser.setVisibility(View.GONE);
                remove_browser.setVisibility(View.GONE);
                break;
            default:
                break;
        }
    }

    private void initGDTBanner() {
        this.bv = new BannerView(this, ADSize.BANNER, Constants.APPID_GDT, Constants.BannerPosID_GDT);
        // 注意：如果开发者的banner不是始终展示在屏幕中的话，请关闭自动刷新，否则将导致曝光率过低。
        // 并且应该自行处理：当banner广告区域出现在屏幕后，再手动loadAD。
        bv.setRefresh(30);
        bv.setADListener(new AbstractBannerADListener() {

            @Override
            public void onNoAD(int arg0) {
                Log.i("AD_DEMO", "BannerNoAD，eCode=" + arg0);
            }

            @Override
            public void onADReceiv() {
                Log.i("AD_DEMO", "ONBannerReceive");
                // 广告已经渲染出来
                if (banner_browser != null) {
                    remove_browser.setVisibility(View.VISIBLE);
                }
            }
        });
        banner_browser.addView(bv);
        bv.loadAD();
        banner_browser.setVisibility(View.VISIBLE);
        banner_browser.setGravity(Gravity.BOTTOM);
        remove_browser.setOnClickListener(this);
    }

    //横幅广告
    private void initBaiDuBanner() {
        // 默认请求http广告，若需要请求https广告，请设置AdSettings.setSupportHttps为true
        AdSettings.setSupportHttps(true);
        // 代码设置AppSid，此函数必须在AdView实例化前调用
        // AdView.setAppSid("debug");
        // 设置'广告着陆页'动作栏的颜色主题
        // 目前开放了七大主题：黑色、蓝色、咖啡色、绿色、藏青色、红色、白色(默认) 主题
        AppActivity
                .setActionBarColorTheme(AppActivity.ActionBarColorTheme.ACTION_BAR_WHITE_THEME);
        // 另外，也可设置动作栏中单个元素的颜色, 颜色参数为四段制，0xFF(透明度, 一般填FF)DE(红)DA(绿)DB(蓝)
        // AppActivity.getActionBarColorTheme().set[Background|Title|Progress|Close]Color(0xFFDEDADB);
        // 创建广告View
        String adPlaceId = Constants.BannerPosID_BD; //  重要：请填上您的广告位ID，代码位错误会导致无法请求到广告
        adView = new AdView(this, adPlaceId);
        // 设置监听器
        adView.setListener(new AdViewListener() {
            public void onAdSwitch() {

            }

            public void onAdShow(JSONObject info) {
                // 广告已经渲染出来
                if (banner_browser != null) {
                    remove_browser.setVisibility(View.VISIBLE);
                }
            }

            public void onAdReady(AdView adView) {
                // 资源已经缓存完毕，还没有渲染出来
            }

            public void onAdFailed(String reason) {

            }

            public void onAdClick(JSONObject info) {
            }

            @Override
            public void onAdClose(JSONObject arg0) {

            }
        });
        banner_browser.addView(adView);
        banner_browser.setVisibility(View.VISIBLE);
        banner_browser.setGravity(Gravity.BOTTOM);

        remove_browser.setOnClickListener(this);
    }

    //手机返回键回退页面
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            if (mTencentWebView != null && mTencentWebView.canGoBack()) {
//                mTencentWebView.goBack();
//                return true;
//            } else {
//                finish();
//                return true;
//            }
//        }
        finish();
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mTencentWebView != null) {
            mTencentWebView.destroy();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mTencentWebView.onPause();
        mTencentWebView.pauseTimers();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mTencentWebView.onResume();
        mTencentWebView.resumeTimers();
    }
}
