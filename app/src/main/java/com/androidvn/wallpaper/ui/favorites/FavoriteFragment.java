package com.androidvn.wallpaper.ui.favorites;

import android.os.Bundle;

import com.androidvn.wallpaper.R;
import com.androidvn.wallpaper.ui.base.BaseFragment;
import com.androidvn.wallpaper.ui.gallery.GalleryFragment;

public class FavoriteFragment extends BaseFragment {

    public static FavoriteFragment newInstances(){
        FavoriteFragment fragment = new FavoriteFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_favorite;
    }

    @Override
    public void onCreateView() {

    }

    @Override
    public void setActionForViews() {

    }

    @Override
    public void showBottomNavigationMenu() {

    }

    @Override
    public void hideBottomNavigationMenu() {

    }
}
