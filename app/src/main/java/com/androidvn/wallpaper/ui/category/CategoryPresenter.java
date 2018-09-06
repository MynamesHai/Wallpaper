package com.androidvn.wallpaper.ui.category;

import android.content.Context;

import com.androidvn.wallpaper.data.local.greendao.DataHelper;
import com.androidvn.wallpaper.data.model.BaseResponse;
import com.androidvn.wallpaper.data.model.category.Categories;
import com.androidvn.wallpaper.data.model.category.CategoryInfo;
import com.androidvn.wallpaper.data.network.RequestApi;
import com.androidvn.wallpaper.data.network.RequestCallBack;
import com.androidvn.wallpaper.data.network.api.AppApiHelper;
import com.androidvn.wallpaper.ui.base.BasePresenter;
import com.androidvn.wallpaper.utils.Utils;
import com.utility.DebugLog;

import java.util.List;

public class CategoryPresenter extends BasePresenter<CategoryMvp> implements RequestCallBack {
    private Context mContext;
    private AppApiHelper mApiHelper;
    private DataHelper mDataHelper;

    public CategoryPresenter(Context mContext) {
        this.mContext = mContext;
        mApiHelper = new AppApiHelper(mContext);
        mDataHelper = new DataHelper(mContext);
    }

    public void doGetCategories() {
        if (getMvpView() != null){
            getMvpView().showLoading();
        }
        mApiHelper.getCategoriesApiCall(this);
    }

    public void getListCategory(){
        List<CategoryInfo> list = mDataHelper.getCategories();
        DebugLog.logd(list.size());
    }

    @Override
    public void onSuccess(RequestApi TAG, BaseResponse response) {
        Categories categories = (Categories) response.data;
    }

    @Override
    public void onSuccessObject(RequestApi TAG, String response) {
        DebugLog.logd("onSuccessObject : " +response);
        if (TAG.equals(RequestApi.API_LIST_CATEGORY_WALLPAPER)){
            Categories categories = Utils.parserObject(response, Categories.class);
            mDataHelper.insertCategories(categories);
            if (getMvpView() != null && categories != null){
                getMvpView().hideLoading();
                getMvpView().setDataForViews(categories.listCategories);
                DebugLog.logd(categories.listCategories.size());
            }
        }
    }

    @Override
    public void onFailure(RequestApi TAG, String msg) {
        getMvpView().hideLoading();
    }
}
