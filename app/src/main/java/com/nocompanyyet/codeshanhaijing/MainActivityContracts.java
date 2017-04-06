package com.nocompanyyet.codeshanhaijing;

/**
 * Created by Phil Locke on 2017/2/19.
 */

public class MainActivityContracts {
    interface View {
        void updateName(String name);
        void updatePinyin(String pinyin);
    }

    interface Presenter {
        void generateButtonClicked();
    }
}
