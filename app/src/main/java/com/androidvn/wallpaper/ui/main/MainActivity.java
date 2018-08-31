package com.androidvn.wallpaper.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
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
    TrendingFragment trendingFragment;
    CategoryFragment categoryFragment;
    GalleryFragment galleryFragment;
    SettingFragment settingFragment;
    FavoriteFragment favoriteFragment;


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onViewCreated() {
        mContext = this;
        mPresenter = new MainPresenter(mContext);
        mPresenter.attachView(this);
        trendingFragment = new TrendingFragment();
        categoryFragment = new CategoryFragment();
        galleryFragment = new GalleryFragment();
        settingFragment = new SettingFragment();
        favoriteFragment = new FavoriteFragment();
        bottomNavView.enableAnimation(false);
        bottomNavView.enableShiftingMode(false);
        bottomNavView.enableItemShiftingMode(false);
        pushFragment(false, R.id.frame_main, trendingFragment);
    }

    @Override
    public void setActionForViews() {
        //
        bottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_item_home:
                        pushFragment(false, R.id.frame_main, trendingFragment);
                        return true;
                    case R.id.nav_item_category:
                        pushFragment(false, R.id.frame_main, categoryFragment);
                        return true;
                    case R.id.nav_item_gallery:
                        pushFragment(false, R.id.frame_main, galleryFragment);
                        return true;
                    case R.id.nav_item_liked:
                        pushFragment(false, R.id.frame_main, favoriteFragment);
                        return true;
                    case R.id.nav_item_setting:
                        pushFragment(false, R.id.frame_main, settingFragment);
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    @Override
    public void setDataForViews(List<CategoryInfo> listCategories) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

}
