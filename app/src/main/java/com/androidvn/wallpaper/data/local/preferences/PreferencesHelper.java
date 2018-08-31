package com.androidvn.wallpaper.data.local.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


public class PreferencesHelper {
    private SharedPreferences sharedPreferences;
    private Context mContext;
    private static final String PREFS_NAME = "Wallpaper";

    public PreferencesHelper(Context context) {
        this.mContext = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public Context getContext() {
        return mContext;
    }

    public void saveScreenWidth(int height) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(PreferenceKeys.SCREEN_WIDTH, height);
        editor.commit();
    }

    public void saveScreenHeight(int height) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(PreferenceKeys.SCREEN_HEIGHT, height);
        editor.commit();
    }

    public int getScreenWidth() {
        return sharedPreferences.getInt(PreferenceKeys.SCREEN_WIDTH, 0);
    }

    public int getScreenHeight() {
        return sharedPreferences.getInt(PreferenceKeys.SCREEN_HEIGHT, 0);
    }

    public boolean isFirstTimeUseApp() {
        return sharedPreferences.getBoolean(PreferenceKeys.FIRST_TIME_USE_APP, true);
    }

    public void saveStateFirstTimeUseApp(boolean state) throws NullPointerException {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(PreferenceKeys.FIRST_TIME_USE_APP, state);
        editor.commit();
    }

    public void saveBooleanSPR(String key, boolean isValue, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, isValue);
        editor.commit();
    }

    public boolean getBooleanSPR(String key, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getBoolean(key, false);
    }

    public boolean getBooleanGoogleMap(String key, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getBoolean(key, true);
    }

    public void setIntegerSPR(String key, int value, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public int getIntegerSPR(String key, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getInt(key, 0);
    }

    public void saveString(String key, String value, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public String getStringSPR(String key, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(key, "");
    }

    public <T> void saveObjectData(String key, T object) {
        SharedPreferences settings = mContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        Gson gson = new Gson();
        String json = gson.toJson(object);
        editor.putString(key, json);
        editor.apply();
    }

    public <T> T getObject(String key, Class<T> typeClass) {
        SharedPreferences settings = mContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        if (settings.contains(key)) {
            String json = settings.getString(key, null);
            return gson.fromJson(json, new ObjectOfJson<T>(typeClass));
        }
        return null;
    }

    public class ObjectOfJson<T> implements ParameterizedType {
        private Class<T> wrapped;

        public ObjectOfJson(Class<T> wrapper) {
            this.wrapped = wrapper;
        }

        @Override
        public Type[] getActualTypeArguments() {
            return new Type[]{wrapped};
        }

        @Override
        public Type getRawType() {
            return wrapped;
        }

        @Override
        public Type getOwnerType() {
            return null;
        }
    }


}
