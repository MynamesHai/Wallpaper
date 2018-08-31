package com.androidvn.wallpaper.ui.trending.news;

import android.os.Bundle;

import com.androidvn.wallpaper.R;
import com.androidvn.wallpaper.ui.base.BaseFragment;

public class NewFragment extends BaseFragment {

    public static NewFragment newInstance(){
        NewFragment fragment = new NewFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_wallpaper_new;
    }

    @Override
    public void onCreateView() {

    }

    @Override
    public void setActionForViews() {

    }
}
