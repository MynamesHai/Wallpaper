package com.androidvn.wallpaper.data.model.wallpaper;


import com.google.gson.annotations.SerializedName;

public class WallpaperInfo {
    @SerializedName("alias_title")
    public String aliasTitle;

    @SerializedName("title")
    public String titleWallpaper;

    @SerializedName("author")
    public String authorWallpaper;

    @SerializedName("download_count")
    public String downloadCount;

    @SerializedName("thumbnail_url")
    public String thumbnailWallpaper;

    @SerializedName("image_path")
    public String imagePathWallpaper;

    @SerializedName("preview")
    public String previewWallpaper;
}
