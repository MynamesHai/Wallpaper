package com.androidvn.wallpaper.ui.trending.live;

import android.os.Bundle;

import com.androidvn.wallpaper.R;
import com.androidvn.wallpaper.ui.base.BaseFragment;

public class LiveFragment extends BaseFragment {

    public static LiveFragment newInstances(){
        LiveFragment fragment = new LiveFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_wallpaper_live;
    }

    @Override
    public void onCreateView() {

    }

    @Override
    public void setActionForViews() {

    }
}
