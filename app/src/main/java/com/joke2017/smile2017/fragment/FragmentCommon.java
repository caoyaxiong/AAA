package com.joke2017.smile2017.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.joke2017.smile2017.R;
import com.joke2017.smile2017.activity.SearchActivity;
import com.joke2017.smile2017.adapter.HomeAdapter;
import com.joke2017.smile2017.entity.TabDataBean;
import com.joke2017.smile2017.entity.TabTextBean;
import com.joke2017.smile2017.http.Urls;
import com.joke2017.smile2017.utils.JsonUtils;
import com.joke2017.smile2017.utils.OkHttpManager;
import com.joke2017.smile2017.utils.SpUtils;
import com.joke2017.smile2017.utils.ToastUtils;
import com.joke2017.smile2017.view.CustomViewPager;
import com.joke2017.smile2017.view.SearchView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;


public class FragmentCommon extends Fragment implements TabLayout.OnTabSelectedListener {

    protected Activity mActivity;
    private CustomViewPager mHomeViewpager;
    private SearchView mHomeSearch;
    private TabLayout mHomeTabLayout;
    private Intent mIntent;
    private HomeAdapter mHomeAdapter;
    List<TabTextBean.DataBean.ChannelsBean> mChannels;
    String spTabName;
    private TextView mCommon_title;
    private RelativeLayout mTop_bar;
    private static TabDataBean sTabDataBean;

    public static FragmentCommon newInstance(Bundle bundle) {
        FragmentCommon fragmentCommon = new FragmentCommon();
//        Bundle bundle=new Bundle();
//        bundle.putString("text",text);
        fragmentCommon.setArguments(bundle);
        return fragmentCommon;
    }

    private void setArguments(TabDataBean tabDataBean) {
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mActivity = null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        View view=inflater.inflate(R.layout.fragment_common,container,false);
//        textView= (TextView) view.findViewById(R.id.textView);
//        textView.setText(getArguments().getString("text"));

        View view = inflater.inflate(R.layout.fragment_common, null, false);
        mHomeViewpager = view.findViewById(R.id.home_viewpager);
        mHomeTabLayout = view.findViewById(R.id.home_tabs);  // 初始化标签
        mHomeSearch = view.findViewById(R.id.search_view);
        mCommon_title = view.findViewById(R.id.common_title);
        mTop_bar = view.findViewById(R.id.top_bar);
        //判断顶部显示状态 0 不显示；2 展示title；1 展示搜索框
        int nav_bar=1;
        if (nav_bar==0){
            //顶部隐藏
        }else if (nav_bar==1) {
            int status_style=1;
            if(status_style==1){
                mHomeSearch.setVisibility(View.VISIBLE);
                mTop_bar.setVisibility(View.VISIBLE);
                mHomeSearch.setEnabled(true);
                mHomeSearch.setSearch_edOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(getContext(), SearchActivity.class);
                        startActivity(intent);
                    }
                });
            }else if (status_style==2){
                mCommon_title.setText("标题");
                mCommon_title.setTextSize(TypedValue.COMPLEX_UNIT_PX, 36);
                mCommon_title.setBackgroundColor(getResources().getColor(R.color.orange));
                mTop_bar.setBackgroundColor(getResources().getColor(R.color.orange));
                mCommon_title.setVisibility(View.VISIBLE);
                mTop_bar.setVisibility(View.VISIBLE);
            }

        }
        mHomeAdapter = new HomeAdapter(getChildFragmentManager(), new ArrayList<TabTextBean.DataBean.ChannelsBean>());
        mHomeViewpager.setAdapter(mHomeAdapter);
        // 将ViewPager和TabLayout绑定
        mHomeTabLayout.setupWithViewPager(mHomeViewpager);
        mHomeTabLayout.addOnTabSelectedListener(this);

        return view;

    }

    private void initData() {
        final int index = 1;
        String channelUrl = Urls.CHANNEL_DATA + "?" + "app_id=" + index;
        spTabName = SpUtils.getStringParam(mActivity, "tabName", null);
        if (!TextUtils.isEmpty(spTabName)) {
            parseTabData(spTabName);
        }
        OkHttpManager.enqueueAsync(channelUrl, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                if (mActivity != null) {
                    mActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ToastUtils.show(mActivity, "获取数据失败", 2000);
                        }
                    });
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                ResponseBody body = response.body();
                String string = body.string();
                if (!TextUtils.equals(spTabName, string)) {
                    spTabName = string;
                    parseTabData(spTabName);
                    SpUtils.putParam(mActivity, "tabName", string);
                }
            }
        });
    }

    private void parseTabData(String string) {
        TabTextBean mTabText = JsonUtils.json2Bean(string, TabTextBean.class);
        mChannels = mTabText.getData().getChannels();
        if (mActivity != null) {
            mActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    setDataAndTabs(mChannels);
                }
            });
        }
    }

    private void setDataAndTabs(List<TabTextBean.DataBean.ChannelsBean> tempChannles) {
        mHomeAdapter.setmTabs(tempChannles);
        mHomeViewpager.setOffscreenPageLimit(tempChannles.size());
        if (mHomeTabLayout.getTabCount() > 0) {
            mHomeTabLayout.removeAllTabs();
        }

        for (int i = 0; i < tempChannles.size(); i++) {
            //判断频道分类，只有一个频道时，隐藏状态栏
            if (tempChannles.size() == 1) {
                mHomeTabLayout.addTab(mHomeTabLayout.newTab().setText(tempChannles.get(i).getCname()));
                mHomeTabLayout.setVisibility(View.GONE);
            } else {
                mHomeTabLayout.addTab(mHomeTabLayout.newTab().setText(tempChannles.get(i).getCname()));


            }
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (Activity) context;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        int position = tab.getPosition();
        mHomeViewpager.setCurrentItem(position);
        //设置Tab字体颜色属性
        mHomeTabLayout.setTabTextColors(Color.BLACK,Color.parseColor("#33aad9"));
        //设置Tab背景颜色属性
        mHomeTabLayout.setBackgroundColor(Color.WHITE);
         /*Tab 选中之后，改变各个Tab的状态*/
        for (int i = 0; i < mHomeTabLayout.getTabCount(); i++) {
            View view = mHomeTabLayout.getTabAt(i).getCustomView();
            if (view == null) return;
            TextView text = view.findViewById(R.id.custom_tablayout_text);
            //修改Tab字体size
            text.setTextSize(TypedValue.COMPLEX_UNIT_PX,36);
            if (i == tab.getPosition()) { // 选中状态
                text.setText(mChannels.get(i).getCname());
            } else {// 未选中状态
                text.setText(mChannels.get(i).getCname());
            }
        }
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
