package com.androidvn.wallpaper.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.androidvn.wallpaper.R;
import com.androidvn.wallpaper.data.model.category.CategoryInfo;
import com.androidvn.wallpaper.ui.base.BaseActivity;
import com.androidvn.wallpaper.ui.category.CategoryFragment;
import com.androidvn.wallpaper.ui.favorites.FavoriteFragment;
import com.androidvn.wallpaper.ui.gallery.GalleryFragment;
import com.androidvn.wallpaper.ui.settings.SettingFragment;
import com.androidvn.wallpaper.ui.trending.TrendingFragment;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainMvp {

    @BindView(R.id.bottom_nav_view)
    BottomNavigationViewEx bottomNavView;
    private MainPresenter mPresenter;
    private Context mContext;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onViewCreated() {
        Log.d("test1", "onViewCreated: ");
        mContext = this;
        mPresenter = new MainPresenter(mContext);
        mPresenter.attachView(this);
        bottomNavView.enableAnimation(false);
        bottomNavView.enableShiftingMode(false);
        bottomNavView.enableItemShiftingMode(false);
        pushFragment(false, R.id.frame_main, TrendingFragment.newInstances());
    }

    @Override
    public void setActionForViews() {
        bottomNavView.setOnNavigationItemSelectedListener(item -> {
            Log.d("test", "onNavigationItemSelected: ");
            switch (item.getItemId()) {
                case R.id.nav_item_home:
                    pushFragment(false, R.id.frame_main, TrendingFragment.newInstances());
                    Log.d("test", "click trendingF: ");
                    return true;
                case R.id.nav_item_category:
                    pushFragment(false, R.id.frame_main, CategoryFragment.newInstances());
                    return true;
                case R.id.nav_item_gallery:
                    pushFragment(false, R.id.frame_main, GalleryFragment.newInstances());
                    return true;
                case R.id.nav_item_liked:
                    pushFragment(false, R.id.frame_main, FavoriteFragment.newInstances());
                    return true;
                case R.id.nav_item_setting:
                    pushFragment(false, R.id.frame_main, SettingFragment.newInstances());
                    return true;
                default:
                    return false;
            }
        });
    }

    @Override
    public void setDataForViews(List<CategoryInfo> listCategories) {
    }

    public BottomNavigationViewEx getNavViewBottom() {
        return bottomNavView;
    }

}
