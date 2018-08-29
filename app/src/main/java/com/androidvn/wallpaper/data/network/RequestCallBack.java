package com.androidvn.wallpaper.data.network;


import com.androidvn.wallpaper.data.model.BaseResponse;

public interface RequestCallBack<T> {
    void onSuccess(RequestApi TAG, BaseResponse response);

    void onSuccessObject(RequestApi TAG, String response);

    void onFailure(RequestApi TAG, String msg);

}