package com.joke2017.smile2017.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.gyf.barlibrary.ImmersionBar;
import com.heima.tabview.library.TabView;
import com.heima.tabview.library.TabViewChild;
import com.joke2017.smile2017.R;
import com.joke2017.smile2017.entity.TabDataBean;
import com.joke2017.smile2017.entity.TableConfigBean;
import com.joke2017.smile2017.fragment.FragmentCommon;
import com.joke2017.smile2017.utils.OkhttpRequest;
import com.umeng.analytics.MobclickAgent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Curry on 2017/9/19.
 */

public class ContentActivity extends FragmentActivity implements OkhttpRequest.CallBackToData {
    private long clickTime = 0;
    TabView tabView;
    TableConfigBean data;
    List<TabViewChild> tabViewChildList;
    List<String> selectIconList;
    List<String> unSelectIconList;
    List<String> tabsTextList;
    private ImmersionBar mImmersionBar;
    Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mTabDataBean = (TabDataBean) msg.obj;
        }
    };
    private TabDataBean mTabDataBean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_activity);
        initTitleView();
        getData();
        tabView = findViewById(R.id.tabView);

        if (tabView != null) {
            //底部tab_bar属性配置
            tabView.setTextViewSelectedColor(getResources().getColor(R.color.blue));
            tabView.setTextViewUnSelectedColor(Color.BLACK);
            tabView.setTabViewBackgroundColor(Color.parseColor("#f3f3f3"));
            tabView.setTabViewHeight(dip2px(52));
            tabView.setImageViewTextViewMargin(2);
            tabView.setTextViewSize(10);
            tabView.setImageViewWidth(dip2px(20));
            tabView.setImageViewHeight(dip2px(20));
            tabView.setTabViewGravity(Gravity.TOP);
            tabView.setTabViewDefaultPosition(0);
            tabView.setTabViewChild(tabViewChildList, getSupportFragmentManager());
        }

//        Toast.makeText(this,data.getApp_config().getTabs().size(),Toast.LENGTH_LONG).show();
    }
    /*给系统状态栏进行着色*/
    protected void initTitleView() {
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.statusBarColor(R.color.black);
        mImmersionBar.init();   //所有子类都将继承这些相同的属性
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);


    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);


    }


    public int dip2px(float dpValue) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    private void getData() {
        data = new TableConfigBean();
        tabViewChildList = new ArrayList<>();
        selectIconList = new ArrayList<>();
        unSelectIconList = new ArrayList<>();
        tabsTextList = new ArrayList<>();
        unSelectIconList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1506084778921&di=a5043f409e08cb9135944585852b1f14&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F0182f755facb256ac7251df880b836.png%40900w_1l_2o_100sh.jpg");
        unSelectIconList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1506084778921&di=ce1abb229d790b88d04aafd45056e8ac&imgtype=0&src=http%3A%2F%2Fwww.uimaker.com%2Fuploads%2Fallimg%2F20150529%2F1432861643128226.jpg");
        unSelectIconList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1506084778920&di=b82b54edbfd28bb3533c3c6c6568e27e&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F0122e655f8f3e06ac7251df8686c5f.png");
        tabsTextList.add("首页");
        tabsTextList.add("视频");
        tabsTextList.add("我的");
        selectIconList.add("http://www.th7.cn/d/file/p/2014/03/04/52bc9620aa8aafa89df6d8d9366bd061.jpg");
        selectIconList.add("http://www.th7.cn/d/file/p/2012/10/22/8001243a3c13634d567774793305c6db.png");
        selectIconList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1506081576139&di=79b1ab2ae2dab6f9af70fec9fce92e36&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F015e60574ec8ff32f875a429c09eaa.jpg");
        TableConfigBean.AppConfigBean appConfigData = new TableConfigBean.AppConfigBean();
        TableConfigBean.AppConfigBean.TabsBean tabData;
        TableConfigBean.AppConfigBean.TabsBean.ChannelsBean channelsData = new TableConfigBean.AppConfigBean.TabsBean.ChannelsBean();
        TableConfigBean.AppConfigBean.TabBarBean tabBarData = new TableConfigBean.AppConfigBean.TabBarBean();
        List<TableConfigBean.AppConfigBean.TabsBean> listTabDatas = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            tabData = new TableConfigBean.AppConfigBean.TabsBean();
            List<TableConfigBean.AppConfigBean.TabsBean.ChannelsBean> listChannel = new ArrayList<>();
//            for (int j = 0; j < 4; j++) {
//                channelsData = new TableConfigBean.AppConfigBean.TabsBean.ChannelsBean();
//                channelsData.setTitle("推荐");
//                channelsData.setType("0");
//                channelsData.setCid("1");
//                listChannel.add(channelsData);
//            }
            tabData.setTitle("Tab");
            tabData.setTitle_color("#000000");
            tabData.setChannels(listChannel);
            listTabDatas.add(tabData);
        }
        tabBarData.setBackgroud_color("#FFFFFF");
        appConfigData.setTab_bar(tabBarData);
        appConfigData.setTabs(listTabDatas);
        data.setApp_config(appConfigData);
        Bundle bundle = new Bundle();
        bundle.putString("text", "Tab");

        for (int i = 0; i < data.getApp_config().getTabs().size(); i++) {

            TabViewChild tabViewChild01 = new TabViewChild(selectIconList.get(i),unSelectIconList.get(i), tabsTextList.get(i), FragmentCommon.newInstance(bundle));
            tabViewChildList.add(tabViewChild01);
        }

    }


    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onResume(this);          //统计时长
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    //点击返回键时调用
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    //退出应用程序
    private void exit() {
        if ((System.currentTimeMillis() - clickTime) > 2000) {
            Toast.makeText(getApplicationContext(), "再次点击退出", Toast.LENGTH_SHORT).show();
            clickTime = System.currentTimeMillis();
        } else {
            this.finish();
            System.exit(0);
        }

    }

    @Override
    public void backData(Object data) {
        Message message=Message.obtain(mHandler,0,data);
        mHandler.sendMessage(message);
    }
}
