package com.nocompanyyet;

/**
 * 山海经-怪物、神兽等
 * Created by Phil Locke on 2017/2/15.
 */

public class ShanHaiJingThing {
    /**
     * 名称
     */
    private String name;
    /**
     * 名称对应的拼音
     */
    private String pinyin;
    /**
     * 是否已使用
     */
    private boolean isUsed = false;

    public ShanHaiJingThing() {
    }

    public ShanHaiJingThing(String name, String pinyin, boolean isUsed) {
        this.name = name;
        this.pinyin = pinyin;
        this.isUsed = isUsed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }
}
