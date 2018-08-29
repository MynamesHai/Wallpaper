package com.androidvn.wallpaper.data.network;


import com.androidvn.wallpaper.data.model.BaseResponse;

public interface RequestCallBack {
    void onSuccess(RequestApi TAG, BaseResponse response);

    void onFailure(RequestApi TAG, String msg);

}