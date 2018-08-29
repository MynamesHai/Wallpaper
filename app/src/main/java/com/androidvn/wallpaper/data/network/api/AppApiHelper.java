package com.androidvn.wallpaper.data.network.api;

import android.content.Context;

import com.android.volley.Request;
import com.androidvn.wallpaper.data.network.BaseRequestQueue;
import com.androidvn.wallpaper.data.network.RequestApi;
import com.androidvn.wallpaper.data.network.RequestCallBack;
import com.androidvn.wallpaper.data.network.VolleyRequest;


public class AppApiHelper {
    private Context mContext;

    public AppApiHelper(Context mContext) {
        this.mContext = mContext;
    }

    public void getCategoriesApiCall(RequestCallBack requestCallBack) {
        StringBuilder builder = new StringBuilder(ApiEndPoint.ENDPOINT_WALLPAPER_V2);
        builder.append("category/get?pid=1&lan=en_US&app_lan=en-US&net=1&aid=8539abca93a62ad5&brand=" +
                "samsung&model=SM-G955F&osv=8.0.0&api_level=26&appv=20600&mcc=452&mnc=04&vga=1080x2094" +
                "&pos=105&count=30&offset=0");
        String url = builder.toString();
        VolleyRequest volleyRequest = new VolleyRequest(Request.Method.GET, url,
                requestCallBack, RequestApi.API_LIST_CATEGORY_WALLPAPER);
        BaseRequestQueue.getInstance().clearCache();
        BaseRequestQueue.getInstance().addToRequestQueue(volleyRequest);
    }

    public void getWallPaperWithTypeApiCall(long id, RequestCallBack requestCallBack) {
        StringBuilder builder = new StringBuilder(ApiEndPoint.ENDPOINT_WALLPAPER_V2);
        builder.append("list/get?pid=1&lan=en_US&app_lan=en-US&net=1&aid=8539abca93a62ad5&brand=" +
                "samsung&model=SM-G955F&osv=8.0.0&api_level=26&appv=20600&mcc=452&mnc=04&vga=1080x2094" +
                "&pos=106&count=30&offset=0");
        builder.append("&cid=" + id);
        String url = builder.toString();
        VolleyRequest volleyRequest = new VolleyRequest(Request.Method.GET, url, requestCallBack,
                RequestApi.API_LIST_WALLPAPER);
        BaseRequestQueue.getInstance().clearCache();
        BaseRequestQueue.getInstance().addToRequestQueue(volleyRequest);
    }

    public void getPopularApiCall(RequestCallBack requestCallBack) {
        StringBuilder builder = new StringBuilder(ApiEndPoint.ENDPOINT_WALLPAPER_V3);
        builder.append("list/get?pid=1&lan=en_US&app_lan=en-US&net=1&aid=8539abca93a62ad5&" +
                "brand=samsung&model=SM-G955F&osv=8.0.0&api_level=26&appv=20600&mcc=452&mnc=04&vga=1080x2094" +
                "&pos=102&count=30&offset=0");
        String url = builder.toString();
        VolleyRequest volleyRequest = new VolleyRequest(Request.Method.GET, url, requestCallBack,
                RequestApi.API_LIST_POPULAR);
        BaseRequestQueue.getInstance().clearCache();
        BaseRequestQueue.getInstance().addToRequestQueue(volleyRequest);
    }

    public void getLiveApiCall(RequestCallBack requestCallBack) {
        StringBuilder builder = new StringBuilder(ApiEndPoint.ENDPOINT_WALLPAPER_V2);
        builder.append("list/get?pid=1&lan=en_US&app_lan=en-US&net=1&aid=8539abca93a62ad5&" +
                "brand=samsung&model=SM-G955F&osv=8.0.0&api_level=26&appv=20600&mcc=452&mnc=04&vga=1080x2094" +
                "&pos=103&count=30&offset=0");
        String url = builder.toString();
        VolleyRequest volleyRequest = new VolleyRequest(Request.Method.GET, url, requestCallBack,
                RequestApi.API_LIVE_WALLPAPER);
        BaseRequestQueue.getInstance().clearCache();
        BaseRequestQueue.getInstance().addToRequestQueue(volleyRequest);
    }

    public void getNewApiCall(RequestCallBack requestCallBack) {
        StringBuilder builder = new StringBuilder(ApiEndPoint.ENDPOINT_WALLPAPER_V3);
        builder.append("list/get?pid=1&lan=en_US&app_lan=en-US&net=1&aid=8539abca93a62ad5&" +
                "brand=samsung&model=SM-G955F&osv=8.0.0&api_level=26&appv=20600&mcc=452&mnc=04&vga=1080x2094" +
                "&pos=101&count=30&offset=0");
        String url = builder.toString();
        VolleyRequest volleyRequest = new VolleyRequest(Request.Method.GET, url, requestCallBack,
                RequestApi.API_NEW_WALLPAPER);
        BaseRequestQueue.getInstance().clearCache();
        BaseRequestQueue.getInstance().addToRequestQueue(volleyRequest);
    }

}
