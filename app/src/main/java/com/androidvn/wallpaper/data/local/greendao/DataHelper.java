package com.androidvn.wallpaper.data.local.greendao;


import android.content.Context;


import com.androidvn.wallpaper.data.local.ApplicationModules;
import com.androidvn.wallpaper.data.local.preferences.PreferencesHelper;
import com.androidvn.wallpaper.data.model.category.Categories;
import com.androidvn.wallpaper.data.model.category.CategoryInfo;
import com.androidvn.wallpaper.data.model.category.DaoSession;

import java.util.List;


public class DataHelper {
    private Context context;
    private PreferencesHelper mPreferenceHelper;
    private DaoSession mDaoSession;

    public DataHelper(Context context) {
        this.context = context;
        mPreferenceHelper = new PreferencesHelper(context);
        mDaoSession = ApplicationModules.getInstances().getDaoSectioṇ̣̣();
    }

    public void insertCategories(Categories categories){
        CategoryInfo categoryInfo = new CategoryInfo();
        categoryInfo.setCategoriesID(categories.getId());
        Long categoriesId = mDaoSession.insert(categoryInfo);
        categories.setId(categoriesId);
        mDaoSession.getCategoriesDao().insert(categories);
    }

    public List<CategoryInfo> getCategories(){
        List<Categories> listCategory = mDaoSession.getCategoriesDao().loadAll();
        List<CategoryInfo> listCategories = listCategory.get(0).listCategories;
        return listCategories;
    }
}
