package com.joke2017.smile2017;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.joke2017.smile2017.http.Constants;
import com.shelwee.update.UpdateHelper;
import com.shelwee.update.listener.OnUpdateListener;
import com.shelwee.update.pojo.UpdateInfo;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.smtt.sdk.QbSdk;
import com.umeng.analytics.MobclickAgent;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;


public class MyApp extends Application {

    private static Context context;
    private PushAgent mPushAgent;
    @Override
    public void onCreate() {
        context = this;
        updateApp();
        //友盟统计
        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);
        mPushAgent = PushAgent.getInstance(getApplicationContext());
        //搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。
        mPushAgent.register(new IUmengRegisterCallback() {
            @Override
            public void onSuccess(String deviceToken) {
                Log.e("deviceToken", deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {

            }
        });
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {
            @Override
            public void onViewInitFinished(boolean arg0) {
                // TODO Auto-generated method stub
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                Log.d("app", " onViewInitFinished is " + arg0);
            }

            @Override
            public void onCoreInitFinished() {
                // TODO Auto-generated method stub
            }
        };
        //x5内核初始化接口
        QbSdk.initX5Environment(getApplicationContext(),  cb);
    }

    /** 获取Application类型的上下文 */
    public static Context getContext() {
        return context;
    }
    //版本升级
    private void updateApp() {
        /**服务器端提供的json格式的数据信息
         * {
         "appName": "TestUpdate",
         "versionCode": "1",
         "versionName": "1.0",
         "apkUrl": "http://www.shelwee.com/404.apk",
         "changeLog":"1.修复xxx Bug;\n2.更新UI界面.",
         "updateTips": "更新提示" ,
         "forceUpgrade": true    //当有新版本时，APP 将会自动下载安装包
         }
         */
        UpdateHelper updateHelper = new UpdateHelper.Builder(this)
                .checkUrl(Constants.URL_UPDATE)
                .isAutoInstall(false) //设置为false需在下载完手动点击安装;默认值为true，下载后自动安装。
                .build();
        updateHelper.check();

        //或者使用下面的方式，针对复杂需求的可重写回调方法
        updateHelper.check(new OnUpdateListener() {

            @Override
            public void onStartDownload() {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStartCheck() {
                // TODO Auto-generated method stub

            }

            @Override
            public void onFinshDownload() {
                // TODO Auto-generated method stub

            }

            @Override
            public void onFinishCheck(UpdateInfo info) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onDownloading(int progress) {
                // TODO Auto-generated method stub

            }
        });
    }


}
