package com.androidvn.wallpaper.ui.base;

import android.content.Context;

public interface BaseMvpView extends MvpView {

    Context getContext();

    void requestPermission(String permission);

    void showLoading();

    void showLoading(String message);

    void hideLoading();

    void showAlertDialog(String message);

    void hideAlertDialog();

    void permissionGranted(String permissionName);

    void permissionDenied();

}
