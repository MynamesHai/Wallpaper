package com.androidvn.wallpaper.data.network.api;

import android.content.Context;

import com.android.volley.Request;
import com.androidvn.wallpaper.data.network.BaseRequestQueue;
import com.androidvn.wallpaper.data.network.RequestApi;
import com.androidvn.wallpaper.data.network.RequestCallBack;
import com.androidvn.wallpaper.data.network.VolleyRequest;
import com.androidvn.wallpaper.utils.Constants;


public class AppApiHelper {
    private Context mContext;

    public AppApiHelper(Context mContext) {
        this.mContext = mContext;
    }


    public void getListCategoryWallpaper(RequestCallBack requestCallBack){
        StringBuilder builder = new StringBuilder(ApiEndPoint.ENDPOINT_WALLPAPER);
        String url = builder.toString();
        VolleyRequest volleyRequest = new VolleyRequest(Request.Method.GET, url,
                requestCallBack, RequestApi.API_LIST_CATEGORY_WALLPAPER);
        BaseRequestQueue.getInstance().clearCache();
        BaseRequestQueue.getInstance().addToRequestQueue(volleyRequest);
    }

}
