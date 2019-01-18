package com.ht.random.ui.fragment;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.ht.random.R;
import com.ht.random.present.GirlPresent;

import butterknife.BindView;
import cn.droidlover.xdroidmvp.event.RxBus;
import cn.droidlover.xdroidmvp.mvp.XFragment;

/**
 * Created by hutao on 2019/1/18.
 */

public class GirlFragment extends XFragment<GirlPresent> {
    @BindView(R.id.girl)
    TextView girl;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_girl;
    }

    @Override
    public GirlPresent newP() {
        return new GirlPresent();
    }

    @Override
    protected void setNext() {
        Log.i("-=-=-=-=-=-=", "Girl里面的设置");
        girl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RxBus.getDefault().post("GirlFragment", "10000");
            }
        });

        getP().load();
    }
}
