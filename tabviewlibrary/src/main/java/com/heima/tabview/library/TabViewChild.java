package com.heima.tabview.library;

import android.support.v4.app.Fragment;


public class TabViewChild {
    private int imageViewSelIcon;
    private int imageViewUnSelIcon;
    private String textViewText;
    private Fragment mFragment;

    private String imageViewSelUrl;
    private String imageViewUnSelUrl;

    public String getImageViewSelUrl() {
        return imageViewSelUrl;
    }

    public void setImageViewSelUrl(String imageViewSelUrl) {
        this.imageViewSelUrl = imageViewSelUrl;
    }

    public String getImageViewUnSelUrl() {
        return imageViewUnSelUrl;
    }

    public void setImageViewUnSelUrl(String imageViewUnSelUrl) {
        this.imageViewUnSelUrl = imageViewUnSelUrl;
    }

    private TabViewChild() {

    }

    public void hideImage() {

    }

    public TabViewChild(String imageViewSelIcon, String imageViewUnSelIcon, String textViewText, Fragment mFragment) {
        this.imageViewSelUrl = imageViewSelIcon;
        this.imageViewUnSelUrl = imageViewUnSelIcon;
        this.textViewText = textViewText;
        this.mFragment = mFragment;
    }

    public TabViewChild(int imageViewSelIcon, int imageViewUnSelIcon, String textViewText, Fragment mFragment) {
        this.imageViewSelIcon = imageViewSelIcon;
        this.imageViewUnSelIcon = imageViewUnSelIcon;
        this.textViewText = textViewText;
        this.mFragment = mFragment;
    }


    public int getImageViewSelIcon() {
        return imageViewSelIcon;
    }


    public void setImageViewSelIcon(int imageViewSelIcon) {
        this.imageViewSelIcon = imageViewSelIcon;
    }


    public int getImageViewUnSelIcon() {
        return imageViewUnSelIcon;
    }


    public void setImageViewUnSelIcon(int imageViewUnSelIcon) {
        this.imageViewUnSelIcon = imageViewUnSelIcon;
    }


    public String getTextViewText() {
        return textViewText;
    }


    public void setTextViewText(String textViewText) {
        this.textViewText = textViewText;
    }


    public Fragment getmFragment() {
        return mFragment;
    }

    public void setmFragment(Fragment mFragment) {
        this.mFragment = mFragment;
    }
}
