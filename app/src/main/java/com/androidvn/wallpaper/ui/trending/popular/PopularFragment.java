package com.androidvn.wallpaper.ui.trending.popular;

import android.os.Bundle;

import com.androidvn.wallpaper.R;
import com.androidvn.wallpaper.ui.base.BaseFragment;

public class PopularFragment extends BaseFragment {

    public static PopularFragment newInstance(){
        PopularFragment fragment = new PopularFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_wallpaper_popular;
    }

    @Override
    public void onCreateView() {

    }

    @Override
    public void setActionForViews() {

    }
}
