package com.androidvn.wallpaper.ui.gallery;

import android.os.Bundle;

import com.androidvn.wallpaper.R;
import com.androidvn.wallpaper.ui.base.BaseFragment;

public class GalleryFragment extends BaseFragment {

    public static GalleryFragment newInstances(){
        GalleryFragment fragment = new GalleryFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_gallery;
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
