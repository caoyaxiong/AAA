package com.joke2017.smile2017.http;

public class Constants {
    public static String APPID_WX = "";
    public static String URL_UPDATE = "http://api.flow.adline.com.cn/api/v3/updateConfig";
    public static String URL_HOME_PAGE = "http://api.flow.adline.com.cn/api/v3/appConfig";
    public static String URL_DATA = "http://192.168.110.110:8080/api/v3/flexibleConfig?app_id=b647425578&c=1";
    public static String DOWNLOAD_DIR = "S-Browser/downloads";
    //百度广告ID，APPID在Androidmanifest中设置
    public static final String BannerPosID_BD = "4644529";
    public static final String InterteristalPosID_BD = "4644520";
    public static final String SplashPosID_BD = "4644505";
    //广点通广告ID
    public static final String APPID_GDT = "1106343462";
    public static final String BannerPosID_GDT = "9080327550511901";
    //public static final String InterteristalPosID_GDT= "9080327550511901";
    public static final String SplashPosID_GDT = "6060725540114900";

    public static final int UPDATE_LOCAL_NOTIFICATION = 1;
    public static final int CREATE_LOCAL_NOTIFICATION = 2;
    public static final int ADD_LOCAL_NOTIFICATION = 3;
    public static final int CLEAR_LOCAL_NOTIFICATION = 4;
    public static final int DELETE_LOCAL_NOTIFICATION = 5;

    /**
     * 主机http://api.flow.adline.com.cn/api/v2/channel?app_id=1
     */
    public static final String HOST = "http://api.flow.adline.com.cn";
    /*详情页*/
    public static final String DETAIL_PAGES = "http://m.adline.com.cn";
    /*http://api.flow.adline.com.cn/api/v2/article?app_id=1&c=0&cid=1&category_id=0&page_token=0&article_id=0&create_time=0
    * http://api.flow.adline.com.cn/api/v2/article/detail
    * */
    /*频道数据*/
    public static final String CHANNEL_DATA = HOST + "/api/v2/channel";
    /*信息流数据*/
    public static final String INFORMATION_DATA = HOST + "/api/v2/article";
    /*详情页数据*/
    public static final String DETAIL_PAGE_DATA = HOST + "/api/v2/article/detail";
    /*评论数据*/
    public static final String REVIEW_DATA = HOST + "/api/v2/comment";
    /*评论提交*/
    public static final String COMMENTS_SUBMITTED = HOST + "/api/v2/comment/create";
    /*反馈互动*/
    public static final String FEEDBACK_INTERACTION = HOST + "/api/v2/feedback";
}
