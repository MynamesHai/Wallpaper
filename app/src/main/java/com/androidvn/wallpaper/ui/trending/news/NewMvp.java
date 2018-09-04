package com.androidvn.wallpaper.ui.trending.news;

import com.androidvn.wallpaper.data.model.news.NewData;
import com.androidvn.wallpaper.ui.base.BaseMvpView;

import java.util.List;

public interface NewMvp extends BaseMvpView {
    void setDataForViews(List<NewData> listNewWallpaper);
}
