package com.ht.random.ui;

import android.os.Bundle;
import android.widget.Toast;

import com.ht.random.present.TestPresent;

import cn.droidlover.xdroidmvp.mvp.XActivity;

public class TestActivity extends XActivity<TestPresent> {

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void setNext() {
        super.setNext();
        getP().start(context, "sadasd");
    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    public void show(String string) {
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show();
    }

    @Override
    public TestPresent newP() {
        return new TestPresent();
    }
}
