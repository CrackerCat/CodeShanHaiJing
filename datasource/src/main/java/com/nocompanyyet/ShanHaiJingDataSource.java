package com.nocompanyyet;

import android.content.Context;

import com.alibaba.fastjson.JSONObject;
import com.nocompanyyet.datasource.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 数据源功能实现
 * Created by Phil Locke on 2017/2/15.
 */

public class ShanHaiJingDataSource extends AbstractShanHaiJingDataSource {
    private static IShanHaiJingDataSource mInstance;
    private Context mContext;
    private ShanHaiJing mShanHaiJing;

    private ShanHaiJingDataSource(Context context) {
        mContext = context;
        initialize();
    }

    public static IShanHaiJingDataSource getInstance(Context... context) {
        if (mInstance == null) {
            synchronized (ShanHaiJingDataSource.class) {
                if (mInstance == null) {
                    mInstance = new ShanHaiJingDataSource(context[0]);
                }
            }
        }
        return mInstance;
    }

    @Override
    void initialize() {
        if (!isDataSourceExist()) {
            newDataSource();
        }
    }

    /**
     * 检查数据源是否已存在
     *
     * @return
     */
    private boolean isDataSourceExist() {
        return mShanHaiJing != null;
    }

    /**
     * 新建数据源
     */
    private void newDataSource() {
        // 从raw文件读取数据
        InputStream is = mContext.getResources().openRawResource(R.raw.shanhaijing_datasource_original);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder total = new StringBuilder();
        String line;
        try {
            while ((line = br.readLine()) != null) {
                total.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String shjJsonString = total.toString().replace(" ", "");

        // 转换成jsonobject进行解析
        mShanHaiJing = JSONObject.parseObject(shjJsonString, ShanHaiJing.class);
    }

    @Override
    public ShanHaiJing getShanHaiJing() {
        return mShanHaiJing;
    }
}