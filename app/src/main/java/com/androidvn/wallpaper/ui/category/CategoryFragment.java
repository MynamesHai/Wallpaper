package com.androidvn.wallpaper.ui.category;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.androidvn.wallpaper.R;
import com.androidvn.wallpaper.data.model.category.CategoryInfo;
import com.androidvn.wallpaper.ui.base.BaseFragment;
import com.androidvn.wallpaper.ui.category.adapter.CategoryAdapter;
import com.androidvn.wallpaper.ui.main.MainActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class CategoryFragment extends BaseFragment implements CategoryMvp {
    private MainActivity mainActivity;
    @BindView(R.id.rv_category)
    RecyclerView rvCate;

    private CategoryAdapter categoryAdapter;
    private CategoryPresenter mPresenter;
    private Context mContext;

    public static CategoryFragment newInstances(){
        CategoryFragment fragment = new CategoryFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_category;
    }

    @Override
    public void onCreateView() {
        mainActivity = ((MainActivity)getContext());
        mContext = getContext();
        mPresenter = new CategoryPresenter(mContext);
        mPresenter.attachView(this);
        initRecycleViews();
        mPresenter.doGetCategories();
    }

    @Override
    public void setActionForViews() {

    }

    @Override
    public void showLoading() {
        super.showLoading();
    }

    @Override
    public void hideLoading() {
        super.hideLoading();
    }

    private void initRecycleViews() {
        categoryAdapter = new CategoryAdapter();
        rvCate.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvCate.setLayoutManager(layoutManager);
        rvCate.setAdapter(categoryAdapter);
        setScrollRecyclerView(rvCate);
    }

    @Override
    public void showBottomNavigationMenu() {
        mainActivity.getNavViewBottom().setVisibility(View.VISIBLE);
    }

    @Override
    public void hideBottomNavigationMenu() {
        mainActivity.getNavViewBottom().setVisibility(View.GONE);
    }

    @Override
    public void setDataForViews(List<CategoryInfo> listCategories) {
        categoryAdapter.addItemsCate(listCategories);
    }
}
