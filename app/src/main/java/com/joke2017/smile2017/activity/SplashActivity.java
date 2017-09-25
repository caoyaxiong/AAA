package com.joke2017.smile2017.activity;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.mobads.AdSettings;
import com.baidu.mobads.SplashAd;
import com.baidu.mobads.SplashAdListener;
import com.joke2017.smile2017.R;
import com.joke2017.smile2017.base.BaseActivity;
import com.joke2017.smile2017.entity.SplashBean;
import com.joke2017.smile2017.http.Constants;
import com.joke2017.smile2017.utils.JsonUtils;
import com.joke2017.smile2017.utils.OkHttpManager;
import com.joke2017.smile2017.utils.ToastUtils;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADListener;
import com.umeng.analytics.MobclickAgent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

//闪屏登陆页面
public class SplashActivity extends BaseActivity implements SplashADListener {
    private TextView skipView;
    private FrameLayout container;
    private ImageView logo_img;
    private RelativeLayout app_logo_rl;
    private SplashAD splashAD_gdt;
    Timer timer = new Timer();
    private SplashAd splashAd_bd;
    private int recLen = 5;
    private long firstClickTime;
    public static int num;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        initView();
        initData();
        initListener();

    }

    public void initData() {
        String splashUrl = Constants.URL_HOME_PAGE;
        OkHttpManager.enqueueAsync(splashUrl, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                SplashActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ToastUtils.show(SplashActivity.this, "获取数据失败", 2000);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                ResponseBody body = response.body();
                String string = body.string();
                parseTabData(string);
            }
        });
    }

    private void parseTabData(String string) {
        SplashBean splashBean = JsonUtils.json2Bean(string, SplashBean.class);
        num = 0;//splashBean.getData().getScreen_ad()
        if (num == 0) {
            viewVisibility();
        } else if (num == 1) {
            splashAd();
        } else if (num == 2) {
            // 如果targetSDKVersion >= 23，就要申请好权限。如果您的App没有适配到Android6.0（即targetSDKVersion < 23），那么只需要在这里直接调用fetchSplashAD接口。
            if (Build.VERSION.SDK_INT >= 23) {
                checkAndRequestPermission();
            } else {
                // 如果是Android6.0以下的机器，默认在安装时获得了所有权限，可以直接调用SDK
                fetchSplashAD(SplashActivity.this, container, skipView, Constants.APPID_GDT, Constants.SplashPosID_GDT, SplashActivity.this, 0);
            }
        }
    }

    @Override
    protected void initView() {
        skipView = (TextView) findViewById(R.id.skip_view);
        container = (FrameLayout) findViewById(R.id.splash_container);
        logo_img = (ImageView) findViewById(R.id.app_logo);
        app_logo_rl = (RelativeLayout) findViewById(R.id.app_logo_rl);

    }

    @Override
    protected void initListener() {
        skipView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        timer.cancel();
                        break;
                    case MotionEvent.ACTION_UP:
                        Intent intent = new Intent(SplashActivity.this, ContentActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }

    //百度开屏广告
    private void splashAd() {
        // 默认请求http广告，若需要请求https广告，请设置AdSettings.setSupportHttps为true
        AdSettings.setSupportHttps(true);
        // 设置视频广告最大缓存占用空间(15MB~100MB),默认30MB,单位MB
        SplashAd.setMaxVideoCacheCapacityMb(30);
        // adUnitContainer
        SplashAdListener listener = new SplashAdListener() {
            @Override
            public void onAdDismissed() {
                jumpWhenCanClick(); // 跳转至您的应用主界面
            }

            @Override
            public void onAdFailed(String arg0) {
                jump();
            }

            @Override
            public void onAdPresent() {
                skipView.setVisibility(View.VISIBLE);
                timer.schedule(task, 0, 1000);
            }

            @Override
            public void onAdClick() {
                // 设置开屏可接受点击时，该回调可用

            }
        };
        String adPlaceId = Constants.SplashPosID_BD; // 重要：请填上您的广告位ID，代码位错误会导致无法请求到广告
        splashAd_bd = new SplashAd(this, container, listener, adPlaceId, true);
    }

    /* Android6.0以上的权限适配简单示例：
     * 如果targetSDKVersion >= 23，那么必须要申请到所需要的权限，再调用广点通SDK，否则广点通SDK不会工作。
     * Demo代码里是一个基本的权限申请示例，请开发者根据自己的场景合理地编写这部分代码来实现权限申请。
     * 注意：下面的`checkSelfPermission`和`requestPermissions`方法都是在Android6.0的SDK中增加的API，如果您的App还没有适配到Android6.0以上，则不需要调用这些方法，直接调用广点通SDK即可。
     */
    @TargetApi(Build.VERSION_CODES.M)
    private void checkAndRequestPermission() {
        List<String> lackedPermission = new ArrayList<String>();
        if (!(checkSelfPermission(Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED)) {
            lackedPermission.add(Manifest.permission.READ_PHONE_STATE);
        }

        if (!(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)) {
            lackedPermission.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }

        if (!(checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)) {
            lackedPermission.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }

        // 权限都已经有了，那么直接调用SDK
        if (lackedPermission.size() == 0) {
            fetchSplashAD(this, container, skipView, Constants.APPID_GDT, Constants.SplashPosID_GDT, this, 0);
        } else {
            // 请求所缺少的权限，在onRequestPermissionsResult中再看是否获得权限，如果获得权限就可以调用SDK，否则不要调用SDK。
            String[] requestPermissions = new String[lackedPermission.size()];
            lackedPermission.toArray(requestPermissions);
            requestPermissions(requestPermissions, 1024);
        }
    }

    private boolean hasAllPermissionsGranted(int[] grantResults) {
        for (int grantResult : grantResults) {
            if (grantResult == PackageManager.PERMISSION_DENIED) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1024 && hasAllPermissionsGranted(grantResults)) {
            fetchSplashAD(this, container, skipView, Constants.APPID_GDT, Constants.SplashPosID_GDT, this, 0);
        } else {
            // 如果用户没有授权，那么应该说明意图，引导用户去设置里面授权。
            Toast.makeText(this, "应用缺少必要的权限！请点击\"权限\"，打开所需要的权限。", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            intent.setData(Uri.parse("package:" + getPackageName()));
            startActivity(intent);
            finish();
        }
    }

    /**
     * 拉取开屏广告，开屏广告的构造方法有3种，详细说明请参考开发者文档。
     *
     * @param activity      展示广告的activity
     * @param adContainer   展示广告的大容器
     * @param skipContainer 自定义的跳过按钮：传入该view给SDK后，SDK会自动给它绑定点击跳过事件。SkipView的样式可以由开发者自由定制，其尺寸限制请参考activity_splash.xml或者接入文档中的说明。
     * @param appId         应用ID
     * @param posId         广告位ID
     * @param adListener    广告状态监听器
     * @param fetchDelay    拉取广告的超时时长：取值范围[3000, 5000]，设为0表示使用广点通SDK默认的超时时长。
     */
    private void fetchSplashAD(Activity activity, ViewGroup adContainer, View skipContainer,
                               String appId, String posId, SplashADListener adListener, int fetchDelay) {
        splashAD_gdt = new SplashAD(activity, adContainer, skipContainer, appId, posId, adListener, fetchDelay);
    }

    @Override//广告渲染完成
    public void onADPresent() {
        skipView.setVisibility(View.VISIBLE);
        timer.schedule(task, 0, 1000);
    }

    @Override//广告中的点击事件
    public void onADClicked() {

    }

    /*  设置广告倒计时
     *  @param millisUntilFinished 剩余毫秒数
     */
    @Override
    public void onADTick(long millisUntilFinished) {
    }

    @Override//广告结束
    public void onADDismissed() {
        jumpWhenCanClick(); // 跳转至您的应用主界面
    }

    @Override//加载广告失败
    public void onNoAD(int errorCode) {
        jump();
    }

    //控制控件显示隐藏
    private void viewVisibility() {
        if (splashAd_bd != null) {
            splashAd_bd.destroy();
        }
        Intent intent = new Intent(SplashActivity.this, ContentActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * 当设置开屏可点击时，需要等待跳转页面关闭后，再切换至您的主窗口。故此时需要增加canJumpImmediately判断。 另外，点击开屏还需要在onResume中调用jumpWhenCanClick接口。
     */
    public boolean canJumpImmediately = false;

    private void jumpWhenCanClick() {
        if (canJumpImmediately) {
            viewVisibility();
        } else {
            canJumpImmediately = true;
        }
    }

    /**
     * 不可点击的开屏，使用该jump方法，而不是用jumpWhenCanClick
     */
    private void jump() {
        viewVisibility();
    }

    //倒计时
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    skipView.setTextColor(Color.WHITE);
                    skipView.setText(recLen + "秒|跳过");
                    recLen--;
                    if (recLen < 1) {
                        timer.cancel();
                        viewVisibility();
                    }

                }
            });
        }
    };

    //手机自身返回键监听
    private void showToastMsg(String msg) {
        Toast.makeText(SplashActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    //手机自身返回键监听
    private void exitApp() {
        long currClickTime = System.currentTimeMillis();
        if (currClickTime - firstClickTime >= 2000) {
            firstClickTime = System.currentTimeMillis();
            showToastMsg("再按一次退出浏览器");
        } else {
            Process.killProcess(Process.myPid());
        }
    }

    //手机返回键回退页面
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        //退无可退就退出APP
        exitApp();
        return true;
    }

    @Override
    public void onDestroy() {
        if (splashAd_bd != null) {
            splashAd_bd.destroy();
        }
        super.onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
        canJumpImmediately = false;
    }

    @Override
    protected void onStop() {
        super.onStop();
        timer.cancel();
    }
}
