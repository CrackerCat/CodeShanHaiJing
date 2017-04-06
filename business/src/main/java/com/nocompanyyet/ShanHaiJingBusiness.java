package com.nocompanyyet;

import android.content.Context;
import android.text.TextUtils;

import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;

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
        ShanHaiJingThing thing = chapter.getThings().get(thingNumber);
        if (TextUtils.isEmpty(thing.getPinyin())) {
            try {
                String oriPinyin = PinyinHelper.convertToPinyinString(thing.getName(), ",", PinyinFormat.WITH_TONE_MARK);
                String[] pinyinSet = oriPinyin.split(",");
                for (int i = 0; i < pinyinSet.length; i++) {
                    String p = pinyinSet[i];
                    p = p.replaceFirst(p.substring(0, 1), p.substring(0, 1).toUpperCase());
                    pinyinSet[i] = p;
                }
                StringBuilder pinyinBuilder = new StringBuilder();
                for (String p : pinyinSet) {
                    pinyinBuilder.append(p);
                }
                thing.setPinyin(pinyinBuilder.toString());
            } catch (PinyinException e) {
                e.printStackTrace();
            }
        }
        return thing;
    }
}
