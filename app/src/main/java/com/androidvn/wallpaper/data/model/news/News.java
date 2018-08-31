package com.androidvn.wallpaper.data.model.news;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class News {
    @SerializedName("ret")
    public long ret;
    @SerializedName("stime")
    public long createdTime;
    @SerializedName("data")
    public List<NewData> listNewDataWallpaper;
}
