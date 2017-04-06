package com.nocompanyyet;

/**
 * 业务逻辑控制接口
 * Created by Phil Locke on 2017/2/15.
 */

public interface IShanHaiJingBusiness {
    /**
     * 随机选取一个ShanHaiJingThing
     *
     * @return
     */
    ShanHaiJingThing getAThingRandomly();
}
