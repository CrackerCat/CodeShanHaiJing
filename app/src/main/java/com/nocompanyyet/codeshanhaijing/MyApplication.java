package com.nocompanyyet.codeshanhaijing;

import android.app.Application;

import com.nocompanyyet.ShanHaiJingBusiness;

/**
 * Created by Phil Locke on 2017/2/15.
 */

public class MyApplication extends Application {
    private static MyApplication mInstance;

    public static Application getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        // 初始化
        ShanHaiJingBusiness.getInstance(this);
    }
}
