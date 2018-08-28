package com.androidvn.wallpaper.data.model.category;

import com.google.gson.annotations.SerializedName;

public class CategoryInfo {

    @SerializedName("category_id")
    public long categoryId;

    @SerializedName("category_name")
    public String categoryName;

    @SerializedName("thumbnail")
    public String categoryThumbnail;
}
