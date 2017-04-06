package com.nocompanyyet;

/**
 * 抽象数据源类
 * Created by Phil Locke on 2017/2/15.
 */

public abstract class AbstractShanHaiJingDataSource implements IShanHaiJingDataSource {
    /**
     * 初始化数据源
     */
    abstract void initialize();
}
