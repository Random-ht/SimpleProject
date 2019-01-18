package com.ht.random.present;

import android.content.Context;

import com.ht.random.ui.TestActivity;

import cn.droidlover.xdroidmvp.mvp.XPresent;

/**
 * Created by hutao on 2019/1/18.
 */

public class TestPresent extends XPresent<TestActivity> {

    public void start(Context context, String string) {
        getV().show(string);
    }
}
