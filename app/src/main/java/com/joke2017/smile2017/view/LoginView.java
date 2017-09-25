package com.joke2017.smile2017.view;

/**
 * Author  : MaxPanda
 * Created : 2017/4/27  15:38
 * Email   : maxpanda0206@gmail.com
 * Describe:
 */

public interface LoginView extends BaseView{
    void setSendVerityEnable(boolean enable);
    void loginType(int code, String msg);
    void qq_Login(int code);
    void wxLoginType(int code);
    void sinaLogin(int code);
    void bindPhoneVerify(boolean isSccess);
    void bindPhoneSuccess(int code, String msg);
}
