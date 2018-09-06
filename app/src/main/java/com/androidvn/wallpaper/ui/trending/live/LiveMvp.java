package com.androidvn.wallpaper.ui.trending.live;

import com.androidvn.wallpaper.data.model.news.NewData;
import com.androidvn.wallpaper.ui.base.BaseMvpView;

import java.util.List;

public interface LiveMvp extends BaseMvpView {
    void setDataForViews(List<NewData> listLiveWallpaper);
}
