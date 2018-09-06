package com.androidvn.wallpaper.ui.trending.live;

import android.content.Context;

import com.androidvn.wallpaper.data.local.greendao.DataHelper;
import com.androidvn.wallpaper.data.model.BaseResponse;
import com.androidvn.wallpaper.data.model.news.News;
import com.androidvn.wallpaper.data.network.RequestApi;
import com.androidvn.wallpaper.data.network.RequestCallBack;
import com.androidvn.wallpaper.data.network.api.AppApiHelper;
import com.androidvn.wallpaper.ui.base.BasePresenter;
import com.androidvn.wallpaper.utils.Utils;
import com.utility.UtilsLib;

public class LivePresenter extends BasePresenter<LiveMvp> implements RequestCallBack{
    private Context mContext;
    private AppApiHelper mApiHelper;
    private DataHelper mDataHelper;

    public LivePresenter(Context context) {
        mContext = context;
        mApiHelper = new AppApiHelper(mContext);
        mDataHelper = new DataHelper(mContext);
    }

    public void doInGetLiveWallpaper() {
        if (getMvpView() != null){
            getMvpView().showLoading();
        }
        mApiHelper.getLiveApiCall(this);
    }

    @Override
    public void onSuccess(RequestApi TAG, BaseResponse response) {

    }

    @Override
    public void onSuccessObject(RequestApi TAG, String response) {
        if (TAG.equals(RequestApi.API_LIVE_WALLPAPER)){
            News news = Utils.parserObject(response, News.class);
            if (getMvpView() != null && news != null){
                getMvpView().setDataForViews(news.listNewDataWallpaper);
            }
        }
    }

    @Override
    public void onFailure(RequestApi TAG, String msg) {
        UtilsLib.showToast(mContext, msg);
    }
}
