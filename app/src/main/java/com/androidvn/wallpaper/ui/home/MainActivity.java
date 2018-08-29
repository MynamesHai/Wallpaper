package com.androidvn.wallpaper.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.androidvn.wallpaper.R;
import com.androidvn.wallpaper.data.model.category.CategoryInfo;
import com.androidvn.wallpaper.ui.base.BaseActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainMvp {
    @BindView(R.id.tv_test_api)
    TextView tvTestApi;

    private MainPresenter mPresenter;
    private Context mContext;


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onViewCreated() {
        mContext = this;
        mPresenter = new MainPresenter(mContext);
        mPresenter.attachView(this);
    }

    @Override
    public void setActionForViews() {

    }

    @Override
    public void setDataForViews(List<CategoryInfo> listCategories) {

    }


    @OnClick(R.id.tv_test_api)
    public void onViewClicked() {
        mPresenter.doGetCategories();
    }
}
