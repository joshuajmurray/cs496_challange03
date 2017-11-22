package com.jmurray.android.challenge03;

import java.util.Random;

/**
 * Created by joshua on 11/22/2017.
 */

public class Names {
    private static String[] mNiceNames;
    private static String[] mRudeNames;
    private String mLastName;

    public Names() {
        mNiceNames = new String[]{"Magnificent", "Awesome", "Special", "Splendid","Majestic"};
        mRudeNames = new String[]{"Arseface", "Moron", "Fool", "Imbecile","Nincompoop"};
    }

    public String getLastName(){
        return mLastName;
    }

    public void setLastName(boolean isNice){
        Random rand = new Random();

        if(isNice) {
            mLastName = mNiceNames[rand.nextInt(mNiceNames.length)];
        } else {
            mLastName = mRudeNames[rand.nextInt(mRudeNames.length)];
        }
    }

}
