package com.androidvn.wallpaper.ui.category;

import com.androidvn.wallpaper.data.model.category.CategoryInfo;
import com.androidvn.wallpaper.ui.base.BaseMvpView;

import java.util.List;

public interface CategoryMvp extends BaseMvpView {
    void setDataForViews(List<CategoryInfo> listCategories);
}
