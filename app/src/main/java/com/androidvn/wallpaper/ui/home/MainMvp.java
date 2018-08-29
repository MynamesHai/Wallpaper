package com.androidvn.wallpaper.ui.home;

import com.androidvn.wallpaper.data.model.category.CategoryInfo;
import com.androidvn.wallpaper.ui.base.BaseMvpView;

public interface MainMvp extends BaseMvpView {

    void setDataForViews(CategoryInfo categoryInfo);
}
