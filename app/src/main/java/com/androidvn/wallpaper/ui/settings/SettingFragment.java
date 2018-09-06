package com.androidvn.wallpaper.ui.settings;

import android.os.Bundle;

import com.androidvn.wallpaper.R;
import com.androidvn.wallpaper.ui.base.BaseFragment;

public class SettingFragment extends BaseFragment {

    public static SettingFragment newInstances(){
        SettingFragment fragment = new SettingFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }
    @Override
    public int getLayoutId() {
        return R.layout.fragment_setting;
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
