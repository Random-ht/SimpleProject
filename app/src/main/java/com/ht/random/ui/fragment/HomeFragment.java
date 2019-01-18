package com.ht.random.ui.fragment;

import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.ht.random.R;
import com.ht.random.model.GankResults;
import com.ht.random.present.HomePresent;

import butterknife.BindView;
import cn.droidlover.xdroidmvp.event.RxBus;
import cn.droidlover.xdroidmvp.mvp.XFragment;

/**
 * Created by hutao on 2019/1/18.
 */

public class HomeFragment extends XFragment<HomePresent> {
    @BindView(R.id.home)
    TextView home;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public HomePresent newP() {
        return new HomePresent();
    }

    @Override
    protected void setNext() {
        Log.i("-=-=-=-=-=-=", "Home里面的设置");
        home.setOnClickListener(v -> {
            RxBus.getDefault().post("HomeFragment", "1000");
        });
        getP().loadData("福利", 1);
    }

    public void showData(int page, GankResults gankResults) {
        Toast.makeText(context, "获取数据成功", Toast.LENGTH_SHORT).show();
    }

}
