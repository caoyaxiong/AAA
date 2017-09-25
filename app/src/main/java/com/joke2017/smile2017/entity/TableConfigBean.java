package com.joke2017.smile2017.entity;

import java.util.List;

/**
 * Created by Curry on 2017/9/18.
 */

public class TableConfigBean {

    /**
     * app_config : {"tab_bar":{"backgroud_color":"","background_url":"","shadow_color":""},"tabs":[{"tab_id":"","title":"","title_color":"","title_select_color":"","icon_url":"","icon_select_url":"","show_nav_bar":"1","nav_bar":{"backgroud_color":"","background_url":"","title":"","title_color":"","font_size":"","status_bar_style":"","shadow_color":""},"page_bar":{"title_color":"#676532","title_select_color":"","font_size":"","font_select_size":"","shadow_color":"","page_bar_style":"","progress_color":""},"channels":[{"title":"","cid":"","url":"","type":""}]}],"loading":{"icon_url":"","title":""}}
     */

    private AppConfigBean app_config;

    public AppConfigBean getApp_config() {
        return app_config;
    }

    public void setApp_config(AppConfigBean app_config) {
        this.app_config = app_config;
    }

    public static class AppConfigBean {
        /**
         * tab_bar : {"backgroud_color":"","background_url":"","shadow_color":""}
         * tabs : [{"tab_id":"","title":"","title_color":"","title_select_color":"","icon_url":"","icon_select_url":"","show_nav_bar":"1","nav_bar":{"backgroud_color":"","background_url":"","title":"","title_color":"","font_size":"","status_bar_style":"","shadow_color":""},"page_bar":{"title_color":"#676532","title_select_color":"","font_size":"","font_select_size":"","shadow_color":"","page_bar_style":"","progress_color":""},"channels":[{"title":"","cid":"","url":"","type":""}]}]
         * loading : {"icon_url":"","title":""}
         */

        private TabBarBean tab_bar;
        private LoadingBean loading;
        private List<TabsBean> tabs;

        public TabBarBean getTab_bar() {
            return tab_bar;
        }

        public void setTab_bar(TabBarBean tab_bar) {
            this.tab_bar = tab_bar;
        }

        public LoadingBean getLoading() {
            return loading;
        }

        public void setLoading(LoadingBean loading) {
            this.loading = loading;
        }

        public List<TabsBean> getTabs() {
            return tabs;
        }

        public void setTabs(List<TabsBean> tabs) {
            this.tabs = tabs;
        }

        public static class TabBarBean {
            /**
             * backgroud_color :
             * background_url :
             * shadow_color :
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

        public static class LoadingBean {
            /**
             * icon_url :
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

        public static class TabsBean {
            /**
             * tab_id :
             * title :
             * title_color :
             * title_select_color :
             * icon_url :
             * icon_select_url :
             * show_nav_bar : 1
             * nav_bar : {"backgroud_color":"","background_url":"","title":"","title_color":"","font_size":"","status_bar_style":"","shadow_color":""}
             * page_bar : {"title_color":"#676532","title_select_color":"","font_size":"","font_select_size":"","shadow_color":"","page_bar_style":"","progress_color":""}
             * channels : [{"title":"","cid":"","url":"","type":""}]
             */

            private String tab_id;
            private String title;
            private String title_color;
            private String title_select_color;
            private String icon_url;
            private String icon_select_url;
            private String show_nav_bar;
            private NavBarBean nav_bar;
            private PageBarBean page_bar;
            private List<ChannelsBean> channels;

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

            public String getIcon_url() {
                return icon_url;
            }

            public void setIcon_url(String icon_url) {
                this.icon_url = icon_url;
            }

            public String getIcon_select_url() {
                return icon_select_url;
            }

            public void setIcon_select_url(String icon_select_url) {
                this.icon_select_url = icon_select_url;
            }

            public String getShow_nav_bar() {
                return show_nav_bar;
            }

            public void setShow_nav_bar(String show_nav_bar) {
                this.show_nav_bar = show_nav_bar;
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

            public List<ChannelsBean> getChannels() {
                return channels;
            }

            public void setChannels(List<ChannelsBean> channels) {
                this.channels = channels;
            }

            public static class NavBarBean {
                /**
                 * backgroud_color :
                 * background_url :
                 * title :
                 * title_color :
                 * font_size :
                 * status_bar_style :
                 * shadow_color :
                 */

                private String backgroud_color;
                private String background_url;
                private String title;
                private String title_color;
                private String font_size;
                private String status_bar_style;
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

                public String getFont_size() {
                    return font_size;
                }

                public void setFont_size(String font_size) {
                    this.font_size = font_size;
                }

                public String getStatus_bar_style() {
                    return status_bar_style;
                }

                public void setStatus_bar_style(String status_bar_style) {
                    this.status_bar_style = status_bar_style;
                }

                public String getShadow_color() {
                    return shadow_color;
                }

                public void setShadow_color(String shadow_color) {
                    this.shadow_color = shadow_color;
                }
            }

            public static class PageBarBean {
                /**
                 * title_color : #676532
                 * title_select_color :
                 * font_size :
                 * font_select_size :
                 * shadow_color :
                 * page_bar_style :
                 * progress_color :
                 */

                private String title_color;
                private String title_select_color;
                private String font_size;
                private String font_select_size;
                private String shadow_color;
                private String page_bar_style;
                private String progress_color;

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

                public String getFont_size() {
                    return font_size;
                }

                public void setFont_size(String font_size) {
                    this.font_size = font_size;
                }

                public String getFont_select_size() {
                    return font_select_size;
                }

                public void setFont_select_size(String font_select_size) {
                    this.font_select_size = font_select_size;
                }

                public String getShadow_color() {
                    return shadow_color;
                }

                public void setShadow_color(String shadow_color) {
                    this.shadow_color = shadow_color;
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
            }

            public static class ChannelsBean {
                /**
                 * title :
                 * cid :
                 * url :
                 * type :
                 */

                private String title;
                private String cid;
                private String url;
                private String type;

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getCid() {
                    return cid;
                }

                public void setCid(String cid) {
                    this.cid = cid;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }
            }
        }
    }
}
