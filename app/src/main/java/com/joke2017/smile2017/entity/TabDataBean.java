package com.joke2017.smile2017.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 111 on 2017/9/12.
 */

public class TabDataBean implements Serializable {

    /**
     * data : {"app_config":{"loading":{"icon_url":"http://www.chinadaily.com.cn/image_c/2017/loading.gif","title":""},"tab_bar":{"backgroud_color":"#ffffff","background_url":"","shadow_color":"#dcd9d9"},"tabs":[{"channels":[{"cid":"1","title":"","type":"","url":"http://api.flow.adline.com.cn/api/v2/article?app_id=1&c=0&cid=1&pageToken=0&articleId=0&createTime=0"}],"icon_select_url":"http://p5.qhimg.com/t01bdccc7cb84ea80a1.png","icon_url":"http://img3.imgtn.bdimg.com/it/u=2137332475,3287188560&fm=27&gp=0.jpg","nav_bar":{"backgroud_color":"#fda76d","background_url":"","font_size":"18","shadow_color":"#060000","status_bar_style":"1","title":"","title_color":"#060000"},"page_bar":{"font_select_size":"16","font_size":"16","page_bar_style":"1","progress_color":"#33aad9","shadow_color":"","title_color":"#060000","title_select_color":"#33aad9"},"show_nav_bar":"1","show_web_page":"0","tab_id":"1","title":"","title_color":"#060000","title_select_color":"#33aad9","web_url":""},{"channels":[{"cid":"2","title":"","type":"","url":"http://api.flow.adline.com.cn/api/v2/article?app_id=1&c=0&cid=1&pageToken=0&articleId=0&createTime=0"}],"icon_select_url":"http://img4.imgtn.bdimg.com/it/u=3413571071,2679609663&fm=27&gp=0.jpg","icon_url":"http://img1.imgtn.bdimg.com/it/u=284142509,1924940060&fm=27&gp=0.jpg","nav_bar":{"backgroud_color":"#fda76d","background_url":"","font_size":"18","shadow_color":"#060000","status_bar_style":"1","title":"","title_color":"#060000"},"page_bar":{"font_select_size":"16","font_size":"16","page_bar_style":"1","progress_color":"#33aad9","shadow_color":"","title_color":"#060000","title_select_color":"#33aad9"},"show_nav_bar":"2","show_web_page":"0","tab_id":"2","title":"","title_color":"#060000","title_select_color":"#33aad9","web_url":""},{"channels":[{"cid":"3","title":"","type":"","url":"http://api.flow.adline.com.cn/api/v2/article?app_id=1&c=0&cid=1&pageToken=0&articleId=0&createTime=0"}],"icon_select_url":"http://img5.imgtn.bdimg.com/it/u=2037857068,123788569&fm=27&gp=0.jpg","icon_url":"http://img5.imgtn.bdimg.com/it/u=3585595759,3754104080&fm=27&gp=0.jpg","nav_bar":{"backgroud_color":"#fda76d","background_url":"","font_size":"18","shadow_color":"#060000","status_bar_style":"1","title":"","title_color":"#060000"},"page_bar":{"font_select_size":"16","font_size":"16","page_bar_style":"1","progress_color":"#33aad9","shadow_color":"","title_color":"#060000","title_select_color":"#33aad9"},"show_nav_bar":"0","show_web_page":"1","tab_id":"3","title":"","title_color":"#060000","title_select_color":"#33aad9","web_url":"http://news.baidu.com/"}]}}
     * status : 0
     */

    private DataBean data;
    private int status;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static class DataBean implements Serializable{
        /**
         * app_config : {"loading":{"icon_url":"http://www.chinadaily.com.cn/image_c/2017/loading.gif","title":""},"tab_bar":{"backgroud_color":"#ffffff","background_url":"","shadow_color":"#dcd9d9"},"tabs":[{"channels":[{"cid":"1","title":"","type":"","url":"http://api.flow.adline.com.cn/api/v2/article?app_id=1&c=0&cid=1&pageToken=0&articleId=0&createTime=0"}],"icon_select_url":"http://p5.qhimg.com/t01bdccc7cb84ea80a1.png","icon_url":"http://img3.imgtn.bdimg.com/it/u=2137332475,3287188560&fm=27&gp=0.jpg","nav_bar":{"backgroud_color":"#fda76d","background_url":"","font_size":"18","shadow_color":"#060000","status_bar_style":"1","title":"","title_color":"#060000"},"page_bar":{"font_select_size":"16","font_size":"16","page_bar_style":"1","progress_color":"#33aad9","shadow_color":"","title_color":"#060000","title_select_color":"#33aad9"},"show_nav_bar":"1","show_web_page":"0","tab_id":"1","title":"","title_color":"#060000","title_select_color":"#33aad9","web_url":""},{"channels":[{"cid":"2","title":"","type":"","url":"http://api.flow.adline.com.cn/api/v2/article?app_id=1&c=0&cid=1&pageToken=0&articleId=0&createTime=0"}],"icon_select_url":"http://img4.imgtn.bdimg.com/it/u=3413571071,2679609663&fm=27&gp=0.jpg","icon_url":"http://img1.imgtn.bdimg.com/it/u=284142509,1924940060&fm=27&gp=0.jpg","nav_bar":{"backgroud_color":"#fda76d","background_url":"","font_size":"18","shadow_color":"#060000","status_bar_style":"1","title":"","title_color":"#060000"},"page_bar":{"font_select_size":"16","font_size":"16","page_bar_style":"1","progress_color":"#33aad9","shadow_color":"","title_color":"#060000","title_select_color":"#33aad9"},"show_nav_bar":"2","show_web_page":"0","tab_id":"2","title":"","title_color":"#060000","title_select_color":"#33aad9","web_url":""},{"channels":[{"cid":"3","title":"","type":"","url":"http://api.flow.adline.com.cn/api/v2/article?app_id=1&c=0&cid=1&pageToken=0&articleId=0&createTime=0"}],"icon_select_url":"http://img5.imgtn.bdimg.com/it/u=2037857068,123788569&fm=27&gp=0.jpg","icon_url":"http://img5.imgtn.bdimg.com/it/u=3585595759,3754104080&fm=27&gp=0.jpg","nav_bar":{"backgroud_color":"#fda76d","background_url":"","font_size":"18","shadow_color":"#060000","status_bar_style":"1","title":"","title_color":"#060000"},"page_bar":{"font_select_size":"16","font_size":"16","page_bar_style":"1","progress_color":"#33aad9","shadow_color":"","title_color":"#060000","title_select_color":"#33aad9"},"show_nav_bar":"0","show_web_page":"1","tab_id":"3","title":"","title_color":"#060000","title_select_color":"#33aad9","web_url":"http://news.baidu.com/"}]}
         */

        private AppConfigBean app_config;

        public AppConfigBean getApp_config() {
            return app_config;
        }

        public void setApp_config(AppConfigBean app_config) {
            this.app_config = app_config;
        }

        public static class AppConfigBean implements Serializable{
            /**
             * loading : {"icon_url":"http://www.chinadaily.com.cn/image_c/2017/loading.gif","title":""}
             * tab_bar : {"backgroud_color":"#ffffff","background_url":"","shadow_color":"#dcd9d9"}
             * tabs : [{"channels":[{"cid":"1","title":"","type":"","url":"http://api.flow.adline.com.cn/api/v2/article?app_id=1&c=0&cid=1&pageToken=0&articleId=0&createTime=0"}],"icon_select_url":"http://p5.qhimg.com/t01bdccc7cb84ea80a1.png","icon_url":"http://img3.imgtn.bdimg.com/it/u=2137332475,3287188560&fm=27&gp=0.jpg","nav_bar":{"backgroud_color":"#fda76d","background_url":"","font_size":"18","shadow_color":"#060000","status_bar_style":"1","title":"","title_color":"#060000"},"page_bar":{"font_select_size":"16","font_size":"16","page_bar_style":"1","progress_color":"#33aad9","shadow_color":"","title_color":"#060000","title_select_color":"#33aad9"},"show_nav_bar":"1","show_web_page":"0","tab_id":"1","title":"","title_color":"#060000","title_select_color":"#33aad9","web_url":""},{"channels":[{"cid":"2","title":"","type":"","url":"http://api.flow.adline.com.cn/api/v2/article?app_id=1&c=0&cid=1&pageToken=0&articleId=0&createTime=0"}],"icon_select_url":"http://img4.imgtn.bdimg.com/it/u=3413571071,2679609663&fm=27&gp=0.jpg","icon_url":"http://img1.imgtn.bdimg.com/it/u=284142509,1924940060&fm=27&gp=0.jpg","nav_bar":{"backgroud_color":"#fda76d","background_url":"","font_size":"18","shadow_color":"#060000","status_bar_style":"1","title":"","title_color":"#060000"},"page_bar":{"font_select_size":"16","font_size":"16","page_bar_style":"1","progress_color":"#33aad9","shadow_color":"","title_color":"#060000","title_select_color":"#33aad9"},"show_nav_bar":"2","show_web_page":"0","tab_id":"2","title":"","title_color":"#060000","title_select_color":"#33aad9","web_url":""},{"channels":[{"cid":"3","title":"","type":"","url":"http://api.flow.adline.com.cn/api/v2/article?app_id=1&c=0&cid=1&pageToken=0&articleId=0&createTime=0"}],"icon_select_url":"http://img5.imgtn.bdimg.com/it/u=2037857068,123788569&fm=27&gp=0.jpg","icon_url":"http://img5.imgtn.bdimg.com/it/u=3585595759,3754104080&fm=27&gp=0.jpg","nav_bar":{"backgroud_color":"#fda76d","background_url":"","font_size":"18","shadow_color":"#060000","status_bar_style":"1","title":"","title_color":"#060000"},"page_bar":{"font_select_size":"16","font_size":"16","page_bar_style":"1","progress_color":"#33aad9","shadow_color":"","title_color":"#060000","title_select_color":"#33aad9"},"show_nav_bar":"0","show_web_page":"1","tab_id":"3","title":"","title_color":"#060000","title_select_color":"#33aad9","web_url":"http://news.baidu.com/"}]
             */

            private LoadingBean loading;
            private TabBarBean tab_bar;
            private List<TabsBean> tabs;

            public LoadingBean getLoading() {
                return loading;
            }

            public void setLoading(LoadingBean loading) {
                this.loading = loading;
            }

            public TabBarBean getTab_bar() {
                return tab_bar;
            }

            public void setTab_bar(TabBarBean tab_bar) {
                this.tab_bar = tab_bar;
            }

            public List<TabsBean> getTabs() {
                return tabs;
            }

            public void setTabs(List<TabsBean> tabs) {
                this.tabs = tabs;
            }

            public static class LoadingBean implements Serializable{
                /**
                 * icon_url : http://www.chinadaily.com.cn/image_c/2017/loading.gif
                 * title :
                 */

                private String icon_url;
                private String title;

                public String getIcon_url() {
                    return icon_url;
                }

                public void setIcon_url(String icon_url) {
                    this.icon_url = icon_url;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }
            }

            public static class TabBarBean implements Serializable{
                /**
                 * backgroud_color : #ffffff
                 * background_url :
                 * shadow_color : #dcd9d9
                 */

                private String backgroud_color;
                private String background_url;
                private String shadow_color;

                public String getBackgroud_color() {
                    return backgroud_color;
                }

                public void setBackgroud_color(String backgroud_color) {
                    this.backgroud_color = backgroud_color;
                }

                public String getBackground_url() {
                    return background_url;
                }

                public void setBackground_url(String background_url) {
                    this.background_url = background_url;
                }

                public String getShadow_color() {
                    return shadow_color;
                }

                public void setShadow_color(String shadow_color) {
                    this.shadow_color = shadow_color;
                }
            }

            public static class TabsBean implements Serializable{
                /**
                 * channels : [{"cid":"1","title":"","type":"","url":"http://api.flow.adline.com.cn/api/v2/article?app_id=1&c=0&cid=1&pageToken=0&articleId=0&createTime=0"}]
                 * icon_select_url : http://p5.qhimg.com/t01bdccc7cb84ea80a1.png
                 * icon_url : http://img3.imgtn.bdimg.com/it/u=2137332475,3287188560&fm=27&gp=0.jpg
                 * nav_bar : {"backgroud_color":"#fda76d","background_url":"","font_size":"18","shadow_color":"#060000","status_bar_style":"1","title":"","title_color":"#060000"}
                 * page_bar : {"font_select_size":"16","font_size":"16","page_bar_style":"1","progress_color":"#33aad9","shadow_color":"","title_color":"#060000","title_select_color":"#33aad9"}
                 * show_nav_bar : 1
                 * show_web_page : 0
                 * tab_id : 1
                 * title :
                 * title_color : #060000
                 * title_select_color : #33aad9
                 * web_url :
                 */

                private String icon_select_url;
                private String icon_url;
                private NavBarBean nav_bar;
                private PageBarBean page_bar;
                private String show_nav_bar;
                private String show_web_page;
                private String tab_id;
                private String title;
                private String title_color;
                private String title_select_color;
                private String web_url;
                private List<ChannelsBean> channels;

                public String getIcon_select_url() {
                    return icon_select_url;
                }

                public void setIcon_select_url(String icon_select_url) {
                    this.icon_select_url = icon_select_url;
                }

                public String getIcon_url() {
                    return icon_url;
                }

                public void setIcon_url(String icon_url) {
                    this.icon_url = icon_url;
                }

                public NavBarBean getNav_bar() {
                    return nav_bar;
                }

                public void setNav_bar(NavBarBean nav_bar) {
                    this.nav_bar = nav_bar;
                }

                public PageBarBean getPage_bar() {
                    return page_bar;
                }

                public void setPage_bar(PageBarBean page_bar) {
                    this.page_bar = page_bar;
                }

                public String getShow_nav_bar() {
                    return show_nav_bar;
                }

                public void setShow_nav_bar(String show_nav_bar) {
                    this.show_nav_bar = show_nav_bar;
                }

                public String getShow_web_page() {
                    return show_web_page;
                }

                public void setShow_web_page(String show_web_page) {
                    this.show_web_page = show_web_page;
                }

                public String getTab_id() {
                    return tab_id;
                }

                public void setTab_id(String tab_id) {
                    this.tab_id = tab_id;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getTitle_color() {
                    return title_color;
                }

                public void setTitle_color(String title_color) {
                    this.title_color = title_color;
                }

                public String getTitle_select_color() {
                    return title_select_color;
                }

                public void setTitle_select_color(String title_select_color) {
                    this.title_select_color = title_select_color;
                }

                public String getWeb_url() {
                    return web_url;
                }

                public void setWeb_url(String web_url) {
                    this.web_url = web_url;
                }

                public List<ChannelsBean> getChannels() {
                    return channels;
                }

                public void setChannels(List<ChannelsBean> channels) {
                    this.channels = channels;
                }

                public static class NavBarBean implements Serializable{
                    /**
                     * backgroud_color : #fda76d
                     * background_url :
                     * font_size : 18
                     * shadow_color : #060000
                     * status_bar_style : 1
                     * title :
                     * title_color : #060000
                     */

                    private String backgroud_color;
                    private String background_url;
                    private String font_size;
                    private String shadow_color;
                    private String status_bar_style;
                    private String title;
                    private String title_color;

                    public String getBackgroud_color() {
                        return backgroud_color;
                    }

                    public void setBackgroud_color(String backgroud_color) {
                        this.backgroud_color = backgroud_color;
                    }

                    public String getBackground_url() {
                        return background_url;
                    }

                    public void setBackground_url(String background_url) {
                        this.background_url = background_url;
                    }

                    public String getFont_size() {
                        return font_size;
                    }

                    public void setFont_size(String font_size) {
                        this.font_size = font_size;
                    }

                    public String getShadow_color() {
                        return shadow_color;
                    }

                    public void setShadow_color(String shadow_color) {
                        this.shadow_color = shadow_color;
                    }

                    public String getStatus_bar_style() {
                        return status_bar_style;
                    }

                    public void setStatus_bar_style(String status_bar_style) {
                        this.status_bar_style = status_bar_style;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getTitle_color() {
                        return title_color;
                    }

                    public void setTitle_color(String title_color) {
                        this.title_color = title_color;
                    }
                }

                public static class PageBarBean implements Serializable{
                    /**
                     * font_select_size : 16
                     * font_size : 16
                     * page_bar_style : 1
                     * progress_color : #33aad9
                     * shadow_color :
                     * title_color : #060000
                     * title_select_color : #33aad9
                     */

                    private String font_select_size;
                    private String font_size;
                    private String page_bar_style;
                    private String progress_color;
                    private String shadow_color;
                    private String title_color;
                    private String title_select_color;

                    public String getFont_select_size() {
                        return font_select_size;
                    }

                    public void setFont_select_size(String font_select_size) {
                        this.font_select_size = font_select_size;
                    }

                    public String getFont_size() {
                        return font_size;
                    }

                    public void setFont_size(String font_size) {
                        this.font_size = font_size;
                    }

                    public String getPage_bar_style() {
                        return page_bar_style;
                    }

                    public void setPage_bar_style(String page_bar_style) {
                        this.page_bar_style = page_bar_style;
                    }

                    public String getProgress_color() {
                        return progress_color;
                    }

                    public void setProgress_color(String progress_color) {
                        this.progress_color = progress_color;
                    }

                    public String getShadow_color() {
                        return shadow_color;
                    }

                    public void setShadow_color(String shadow_color) {
                        this.shadow_color = shadow_color;
                    }

                    public String getTitle_color() {
                        return title_color;
                    }

                    public void setTitle_color(String title_color) {
                        this.title_color = title_color;
                    }

                    public String getTitle_select_color() {
                        return title_select_color;
                    }

                    public void setTitle_select_color(String title_select_color) {
                        this.title_select_color = title_select_color;
                    }
                }

                public static class ChannelsBean implements Serializable{
                    /**
                     * cid : 1
                     * title :
                     * type :
                     * url : http://api.flow.adline.com.cn/api/v2/article?app_id=1&c=0&cid=1&pageToken=0&articleId=0&createTime=0
                     */

                    private String cid;
                    private String title;
                    private String type;
                    private String url;

                    public String getCid() {
                        return cid;
                    }

                    public void setCid(String cid) {
                        this.cid = cid;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }
                }
            }
        }
    }
}
