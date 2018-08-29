package com.androidvn.wallpaper.data.model.category;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Categories {
    @SerializedName("stime")
    public long createdTime;

    @SerializedName("data")
    public List<CategoryInfo> listCategories;
}
