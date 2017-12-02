package com.jmurray.android.challenge03;


import android.content.Context;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by joshua on 11/22/2017.
 */

public class Names {
    private static String[] mNiceNames;
    private static String[] mRudeNames;
    private String mLastName;
    private String mFirstName;
    private boolean mIsNice;

    public Names(String name, boolean isNice) {
        mFirstName = name;
        mIsNice = isNice;
        mNiceNames = new String[]{"Magnificent", "Awesome", "Special", "Splendid","Majestic"};
        mRudeNames = new String[]{"Arseface", "Moron", "Fool", "Imbecile","Nincompoop"};
    }

    public String getLastName(boolean isNice){

        Random rand = new Random();

        if(isNice) {
            mLastName = mNiceNames[rand.nextInt(mNiceNames.length)];
        } else {
            mLastName = mRudeNames[rand.nextInt(mRudeNames.length)];
        }
        return mLastName;
    }



}