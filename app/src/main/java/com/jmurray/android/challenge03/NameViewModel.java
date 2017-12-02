package com.jmurray.android.challenge03;

/**
 * Created by joshua on 12/1/2017.
 */

public class NameViewModel {
    private Names mNames;
    private boolean mIsNice;
    private String mName;

    public NameViewModel(String name, boolean isNice) {
        mNames = new Names(name, isNice);
        mIsNice = isNice;
        mName = name;
    }

    public String getLastName() {
        return mName + " " + mNames.getLastName(mIsNice);
    }
}