package com.nocompanyyet;

import java.util.List;

/**
 * 山海经-卷
 * Created by Phil Locke on 2017/2/15.
 */

public class ShanHaiJingChapter {
    /**
     * 卷名
     */
    private String name;
    private List<ShanHaiJingThing> things;

    public ShanHaiJingChapter() {
    }

    public ShanHaiJingChapter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ShanHaiJingThing> getThings() {
        return things;
    }

    public void setThings(List<ShanHaiJingThing> things) {
        this.things = things;
    }
}
