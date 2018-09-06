package com.androidvn.wallpaper.ui.trending.popular;

import com.androidvn.wallpaper.data.model.news.NewData;
import com.androidvn.wallpaper.ui.base.BaseMvpView;

import java.util.List;

public interface PopularMvp extends BaseMvpView {
    void setDataForViews(List<NewData> listPopularWallpaper);
}
