package com.androidvn.wallpaper.data.model.news;

import com.google.gson.annotations.SerializedName;

public class NewData {
    @SerializedName("title")
    public String title;

    @SerializedName("thumbnail_url")
    public String thumbnailUrl;

    @SerializedName("preview")
    public String preview;

    @SerializedName("image_path")
    public String imagePath;
}
