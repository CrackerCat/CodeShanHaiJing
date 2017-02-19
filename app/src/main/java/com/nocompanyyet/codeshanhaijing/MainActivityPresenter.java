package com.nocompanyyet.codeshanhaijing;

import com.nocompanyyet.IShanHaiJingBusiness;
import com.nocompanyyet.ShanHaiJingBusiness;
import com.nocompanyyet.ShanHaiJingThing;

/**
 * Created by Phil Locke on 2017/2/19.
 */

public class MainActivityPresenter implements MainActivityContracts.Presenter {
    private IShanHaiJingBusiness mBusiness = ShanHaiJingBusiness.getInstance();
    private MainActivityContracts.View mView;

    public MainActivityPresenter(MainActivityContracts.View view) {
        mView = view;
    }

    @Override
    public void generateButtonClicked() {
        ShanHaiJingThing thing = mBusiness.getAThingRandomly();
        mView.updateName(thing.getName());
        mView.updatePinyin(thing.getPinyin());
    }
}
