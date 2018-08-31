package com.androidvn.wallpaper.data.local;


import android.content.Context;

import com.androidvn.wallpaper.data.model.category.DaoMaster;
import com.androidvn.wallpaper.data.model.category.DaoSession;
import com.utility.DebugLog;

import org.greenrobot.greendao.database.Database;

import dagger.Module;

public class ApplicationModules {
    public static ApplicationModules mInstances;
    public static final String DATABASE_NAME = "WALLPAPER_DATABASE";

    private DaoSession mDaoSession;
    private Database mDatabase;

    public static ApplicationModules getInstances() {
        if (null == mInstances) {
            mInstances = new ApplicationModules();
        }
        return mInstances;
    }

    public void initData(Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, DATABASE_NAME);
        mDatabase = helper.getWritableDb();
        mDaoSession = new DaoMaster(mDatabase).newSession();
    }

    public DaoSession getDaoSectioṇ̣̣() {
        return mDaoSession;
    }

    public void closeDatabase() {
        try {
            mDaoSession.clear();
            mDatabase.close();
            mDatabase = null;
        } catch (Exception e) {
            DebugLog.logd(e);
        }
    }

}
