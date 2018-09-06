package com.androidvn.wallpaper.utils;

import android.content.Context;
import android.widget.ImageView;

import com.androidvn.wallpaper.R;
import com.androidvn.wallpaper.config.GlideApp;
import com.androidvn.wallpaper.data.model.BaseResponse;
import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Utils {

    public static <T> T parserObject(String json, Class<T> typeClass) {
        Gson gson = new Gson();
        return gson.fromJson(json, new ObjectOfJson<T>(typeClass));
    }


    public static class ObjectOfJson<T> implements ParameterizedType {
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

    public static void loadImageWithGlide(Context context, Object object, ImageView imageView){
        try {
            GlideApp.with(context)
                    .load(object)
                    .centerCrop()
                    .placeholder(R.drawable.custom_item_category)
                    .error(R.drawable.ic_launcher_background)
                    .into(imageView);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
