package com.nocompanyyet;

import android.content.Context;

import java.util.Random;

/**
 * 业务逻辑控制实现
 * Created by Phil Locke on 2017/2/15.
 */

public class ShanHaiJingBusiness implements IShanHaiJingBusiness {
    private static IShanHaiJingBusiness mInstance;
    private IShanHaiJingDataSource mDataSource;
    private ShanHaiJing mShanHaiJing;

    private ShanHaiJingBusiness(Context context) {
        mDataSource = ShanHaiJingDataSource.getInstance(context);
        mShanHaiJing = mDataSource.getShanHaiJing();
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

    @Override
    public ShanHaiJingThing getAThingRandomly() {
        Random random = new Random();
        int chapterNumber;
        if (mShanHaiJing.getChapters().size() == 1) {
            chapterNumber = 0;
        } else {
            chapterNumber = random.nextInt(mShanHaiJing.getChapters().size() - 1);
        }
        ShanHaiJingChapter chapter = mShanHaiJing.getChapters().get(chapterNumber);
        int thingNumber = random.nextInt(chapter.getThings().size() - 1);
        return chapter.getThings().get(thingNumber);
    }
}
