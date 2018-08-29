package com.androidvn.wallpaper.data.model;

public class BaseResponse<T> {
    public int ret;
    public String message;
    public long time;
    public T data;
}
