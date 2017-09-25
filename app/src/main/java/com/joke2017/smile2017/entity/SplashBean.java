package com.joke2017.smile2017.entity;

/**
 * Created by 111 on 2017/8/18.
 */

public class SplashBean {


    /**
     * status : 0
     * data : {"screen_ad":2,"index_url":"http://www.sina.cn"}
     */

    private int status;
    private DataBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * screen_ad : 2
         * index_url : http://www.sina.cn
         */

        private int screen_ad;
        private String index_url;

        public int getScreen_ad() {
            return screen_ad;
        }

        public void setScreen_ad(int screen_ad) {
            this.screen_ad = screen_ad;
        }

        public String getIndex_url() {
            return index_url;
        }

        public void setIndex_url(String index_url) {
            this.index_url = index_url;
        }
    }
}

