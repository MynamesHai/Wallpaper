package com.androidvn.wallpaper.ui.main;

import com.androidvn.wallpaper.data.model.category.CategoryInfo;
import com.androidvn.wallpaper.ui.base.BaseMvpView;

import java.util.List;

public interface MainMvp extends BaseMvpView {

    void setDataForViews(List<CategoryInfo> listCategories);
}
