package com.androidvn.wallpaper.data.network;


public interface RequestCallBack {
    void onSuccess(RequestApi TAG, String response);

    void onFailure(RequestApi TAG, String msg);

}