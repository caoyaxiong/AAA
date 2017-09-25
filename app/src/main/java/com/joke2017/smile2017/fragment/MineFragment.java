package com.joke2017.smile2017.fragment;

import android.os.Bundle;
import android.view.View;

import com.joke2017.smile2017.R;
import com.joke2017.smile2017.base.BaseFragment;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;



public class MineFragment extends BaseFragment {

    private WebView mWebView;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mWebView = view.findViewById(R.id.mine_webview);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("https://www.baidu.com/");
    }

    @Override
    protected void initListener() {
        super.initListener();
      mWebView.setWebViewClient(new WebViewClient(){
          @Override
          public boolean shouldOverrideUrlLoading(WebView webView, String url) {
              webView.loadUrl(url);
              return false;
          }
      });
    }



}
