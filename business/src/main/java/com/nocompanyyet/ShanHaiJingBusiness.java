package com.nocompanyyet;

import android.content.Context;

/**
 * 业务逻辑控制实现
 * Created by Phil Locke on 2017/2/15.
 */

public class ShanHaiJingBusiness implements IShanHaiJingBusiness {
    private static IShanHaiJingBusiness mInstance;
    private IShanHaiJingDataSource mDataSource;

    private ShanHaiJingBusiness(Context context) {
        mDataSource = ShanHaiJingDataSource.getInstance(context);
    }

    public static IShanHaiJingBusiness getInstance(Context... context) {
        if (mInstance == null) {
            synchronized (ShanHaiJingBusiness.class) {
                if (mInstance == null) {
                    mInstance = new ShanHaiJingBusiness(context[0]);
                }
            }
        }
        return mInstance;
    }
}
