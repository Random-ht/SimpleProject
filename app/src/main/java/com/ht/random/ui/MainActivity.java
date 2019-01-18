package com.ht.random.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.ht.random.R;
import com.ht.random.ui.fragment.GirlFragment;
import com.ht.random.ui.fragment.HomeFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.droidlover.xdroidmvp.base.XFragmentAdapter;
import cn.droidlover.xdroidmvp.event.RxBus;
import cn.droidlover.xdroidmvp.mvp.XActivity;

/**
 * Created by wanglei on 2016/12/22.
 */

public class MainActivity extends XActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.dianji)
    TextView dianji;
    @BindView(R.id.text)
    TextView text;

    List<Fragment> fragmentList = new ArrayList<>();
    String[] titles = {"首页", "妹子"};

    XFragmentAdapter adapter;

    @Override
    public void initData(Bundle savedInstanceState) {
        setSupportActionBar(toolbar);

        fragmentList.clear();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new GirlFragment());

        if (adapter == null) {
            adapter = new XFragmentAdapter(getSupportFragmentManager(), fragmentList, titles);
        }
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);

        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public Object newP() {
        return null;
    }

    @Override
    public void initEvent() {
        RxBus.getDefault()
                .subscribe(this, "10000", new RxBus.Callback<String>() {
                    @Override
                    public void onEvent(String s) {
                        text.setText(s);
                    }
                });

        RxBus.getDefault()
                .subscribe(this, "1000", new RxBus.Callback<String>() {
                    @Override
                    public void onEvent(String s) {
                        text.setText(s);
                    }
                });

        RxBus.getDefault()
                .subscribe(this, new RxBus.Callback<String>() {
                    @Override
                    public void onEvent(String s) {
                        text.setText(s);
                    }
                });
    }

    @Override
    protected void setNext() {

        dianji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RxBus.getDefault().post("首页", "111");
            }
        });
    }

    //    @Override
//    public int getOptionsMenuId() {
//        return R.menu.menu_main;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.action_droid:
//                AboutActivity.launch(context);
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }

}
