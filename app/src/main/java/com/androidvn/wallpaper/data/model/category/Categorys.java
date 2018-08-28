package com.androidvn.wallpaper.data.model.category;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Categorys {
    @SerializedName("stime")
    public long createdTime;

    @SerializedName("data")
    public List<CategoryInfo> listCategoryInfo;
}
