package com.androidvn.wallpaper.ui.home;

import android.content.Context;

import com.androidvn.wallpaper.data.model.BaseResponse;
import com.androidvn.wallpaper.data.model.category.Categories;
import com.androidvn.wallpaper.data.network.RequestApi;
import com.androidvn.wallpaper.data.network.RequestCallBack;
import com.androidvn.wallpaper.data.network.api.AppApiHelper;
import com.androidvn.wallpaper.ui.base.BasePresenter;

public class MainPresenter extends BasePresenter<MainMvp> implements RequestCallBack {
    private Context mContext;
    private AppApiHelper mApiHelper;

    public MainPresenter(Context context) {
        this.mContext = context;
    }

    public void doGetCategories() {
        if (getMvpView() != null){
            getMvpView().showLoading();
        }
        mApiHelper.getCategoriesApiCall(this);
    }

    @Override
    public void onSuccess(RequestApi TAG, BaseResponse response) {
        Categories categories = (Categories) response.data;
    }

    @Override
    public void onFailure(RequestApi TAG, String msg) {

    }
}
