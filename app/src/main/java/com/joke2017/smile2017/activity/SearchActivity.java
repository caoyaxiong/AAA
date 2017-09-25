package com.joke2017.smile2017.activity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.joke2017.smile2017.R;
import com.joke2017.smile2017.base.BaseActivity;
import com.joke2017.smile2017.entity.RecordSQLiteOpenHelper;
import com.joke2017.smile2017.view.MyListView;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 跳转到搜索页面
 */

public class SearchActivity extends BaseActivity {
    private EditText et_search;
    private TextView tv_tip;
    private MyListView listView;
    private TextView tv_clear;
    private RecordSQLiteOpenHelper helper = new RecordSQLiteOpenHelper(this);
    private SQLiteDatabase db;
    private SimpleCursorAdapter adapter;
    private ImageView back_img;
    private TextView search_text;
    private TextView history;
    private ImmersionBar mImmersionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();
        initListener();
// 插入数据，便于测试，否则第一次进入没有数据怎么测试呀？
        Date date = new Date();
        long time = date.getTime();


// 第一次进入查询所有的历史记录
        queryData("");
    }

    /**
     *    * 插入数据
     *    
     */
    private void insertData(String tempName) {
        db = helper.getWritableDatabase();
        db.execSQL("insert into records(name) values('" + tempName + "')");
        db.close();
    }

    /**
     *    * 模糊查询数据
     *    
     */
    private void queryData(String tempName) {
        Cursor cursor = helper.getReadableDatabase().rawQuery(
                "select id as _id,name from records where name like '%" + tempName + "%' order by id desc ", null);
// 创建adapter适配器对象
        adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor, new String[]{"name"},
                new int[]{android.R.id.text1}, 0) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                View newView = super.newView(context, cursor, parent);
                ((TextView) newView.findViewById(android.R.id.text1)).setTextColor(Color.GRAY);
                return newView;
            }
        };
// 设置适配器
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    /**
     *    * 检查数据库中是否已经有该条记录
     *    
     */
    private boolean hasData(String tempName) {
        Cursor cursor = helper.getReadableDatabase().rawQuery(
                "select id as _id,name from records where name =?", new String[]{tempName});
//判断是否有下一个
        return cursor.moveToNext();
    }

    /**
     *    * 清空数据
     *    
     */
    private void deleteData() {
        db = helper.getWritableDatabase();
        db.execSQL("delete from records");
        db.close();
    }

    @Override
    protected void initView() {
        back_img = (ImageView) findViewById(R.id.search_back);
        et_search = (EditText) findViewById(R.id.et_search);
        tv_tip = (TextView) findViewById(R.id.tv_tip);
        listView = (MyListView) findViewById(R.id.listView);
        tv_clear = (TextView) findViewById(R.id.tv_clear);
        search_text = (TextView) findViewById(R.id.search_text);
        back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hintKbTwo();
                finish();
            }
        });
// 调整EditText左边的搜索按钮的大小
        Drawable drawable = getResources().getDrawable(R.drawable.search_img);
        drawable.setBounds(0, 0, 60, 60);// 第一0是距左边距离，第二0是距上边距离，60分别是长宽
        et_search.setCompoundDrawables(drawable, null, null, null);// 只放左边
    }
    //此方法只是关闭软键盘
    private void hintKbTwo() {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        if(imm.isActive()&&getCurrentFocus()!=null){
            if (getCurrentFocus().getWindowToken()!=null) {
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    }
    @Override
    protected void initListener() {
        // 清空搜索历史
        tv_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteData();
                queryData("");
            }
        });

// 点击“搜索”实现添加搜索历史
        search_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = et_search.getText().toString();
                // 先隐藏键盘
                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                        getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                if (s.toString().trim().length() == 0) {
                    tv_tip.setTextColor(Color.BLACK);
                    tv_tip.setText("搜索历史");
                } else {
                    tv_tip.setTextColor(Color.BLACK);
                    tv_tip.setText("搜索结果");
                }
                String tempName = et_search.getText().toString();
// 根据tempName去模糊查询数据库中有没有数据
                queryData(tempName);
// 按完搜索键后将当前查询的关键字保存起来,如果该关键字已经存在就不执行保存
                boolean hasData = hasData(et_search.getText().toString().trim());
                if (!hasData) {
                    insertData(et_search.getText().toString().trim());
                    queryData("");
                }
// TODO 根据输入的内容模糊查询商品，并跳转到另一个界面，由你自己去实现
                boolean flag = IsUrl(tempName);
                if (flag) {
                    Intent intent = new Intent(SearchActivity.this, DetailPageActivity.class);
                    intent.putExtra("search_url", tempName);
                    startActivity(intent);
                } else {
                    String url = "http://www.baidu.com/s?wd=" + tempName;
                    Intent intent = new Intent(SearchActivity.this, DetailPageActivity.class);
                    intent.putExtra("search_url", url);
                    startActivity(intent);
                }


            }
        });


// 搜索框的键盘搜索键点击回调
        et_search.setOnKeyListener(new View.OnKeyListener() {// 输入完后按键盘上的搜索键

            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {// 修改回车键功能
// 先隐藏键盘
                    ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                            getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
// 按完搜索键后将当前查询的关键字保存起来,如果该关键字已经存在就不执行保存
                    boolean hasData = hasData(et_search.getText().toString().trim());
                    if (!hasData) {
                        insertData(et_search.getText().toString().trim());
                        queryData("");
                    }
                    String tempName = et_search.getText().toString();
// TODO 根据输入的内容模糊查询商品，并跳转到另一个界面，由你自己去实现
                    //http://www.cnblogs.com/outOfview/p/3467320.html浏览器
                    boolean flag = IsUrl(tempName);
                    if (flag) {
                        Intent intent = new Intent(SearchActivity.this, DetailPageActivity.class);
                        intent.putExtra("search_url", tempName);
                        startActivity(intent);
                    } else {
                        String url = "http://www.baidu.com/s?wd=" + tempName;
                        Intent intent = new Intent(SearchActivity.this, DetailPageActivity.class);
                        intent.putExtra("search_url", url);
                        startActivity(intent);
                    }
                }
                return false;
            }
        });

// 搜索框的文本变化实时监听
        et_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().trim().length() == 0) {
                    tv_tip.setTextColor(Color.BLACK);
                    tv_tip.setText("搜索历史");
                } else {
                    tv_tip.setTextColor(Color.BLACK);
                    tv_tip.setText("搜索结果");
                }
                String tempName = et_search.getText().toString();
// 根据tempName去模糊查询数据库中有没有数据
                queryData(tempName);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view.findViewById(android.R.id.text1);
                String name = textView.getText().toString();
                et_search.setTextColor(Color.BLACK);
                et_search.setText(name);
                String tempName = et_search.getText().toString();
// TODO 获取到item上面的文字，根据该关键字跳转到另一个页面查询，由你自己去实现
                boolean flag = IsUrl(tempName);
                if (flag) {
                    Intent intent = new Intent(SearchActivity.this, DetailPageActivity.class);
                    intent.putExtra("search_url", tempName);
                    startActivity(intent);
                } else {
                    String url = "http://www.baidu.com/s?wd=" + tempName;
                    Intent intent = new Intent(SearchActivity.this, DetailPageActivity.class);
                    intent.putExtra("search_url", url);
                    startActivity(intent);
                }
            }
        });
    }

    public boolean IsUrl(String result) {
        String reg = "((http|ftp|https)://)(([a-zA-Z0-9\\._-]+\\.[a-zA-Z]{2,6})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,4})*(/[a-zA-Z0-9\\&%_\\./-~-]*)?";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(result);
        boolean b = matcher.matches();
        return b;

    }
}