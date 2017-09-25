package com.joke2017.smile2017.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.joke2017.smile2017.R;


/**
 * Created by 111 on 2017/7/31.
 * 自定义搜索框
 */

public class SearchView extends LinearLayout {
    private ImageView login_button;
    private EditText search_ed;
    private Context mContext;
    private View view;

    public SearchView(Context context) {
        super(context);
    }

    public SearchView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;

        //true为显示状态，false隐藏搜索栏目
        view = LayoutInflater.from(mContext).inflate(R.layout.search_view_layout, this,true);
        initView();
    }

    public void setLogin_buttonOnClickListener(OnClickListener listener) {
        login_button.setOnClickListener(listener);
    }
    public void setSearch_edOnClickListener(OnClickListener listener) {
        search_ed.setOnClickListener(listener);
    }


    private void initView() {
        login_button = view.findViewById(R.id.logo_button);
        search_ed = view.findViewById(R.id.search_ed);
        search_ed.setInputType(InputType.TYPE_NULL);
    }

}
