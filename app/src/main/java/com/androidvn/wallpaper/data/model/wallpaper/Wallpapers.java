package com.androidvn.wallpaper.data.model.wallpaper;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Wallpapers {
    @SerializedName("stime")
    public long createdTime;
    @SerializedName("data")
    public List<WallpaperInfo> listWallpaper;
}
