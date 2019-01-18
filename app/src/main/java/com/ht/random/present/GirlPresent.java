package com.ht.random.present;

import com.ht.random.model.UserLoginReturn;
import com.ht.random.net.Api;
import com.ht.random.ui.fragment.GirlFragment;

import cn.droidlover.xdroidmvp.md5.GetLoginCod;
import cn.droidlover.xdroidmvp.mvp.XPresent;
import cn.droidlover.xdroidmvp.net.ApiSubscriber;
import cn.droidlover.xdroidmvp.net.NetError;
import cn.droidlover.xdroidmvp.net.XApi;

/**
 * Created by hutao on 2019/1/18.
 */

public class GirlPresent extends XPresent<GirlFragment> {
    public void load() {
        String s = String.valueOf(System.currentTimeMillis() / 1000);
        String loginCode = GetLoginCod.getlogincod("tel=17607183628" + "callseq=" + s + "password=123456"  );
        Api.getGankService().login("17607183628", loginCode, s)
                .compose(XApi.<UserLoginReturn>getApiTransformer())
                .compose(XApi.<UserLoginReturn>getScheduler())
                .compose(getV().<UserLoginReturn>bindToLifecycle())
                .subscribe(new ApiSubscriber<UserLoginReturn>() {
                    @Override
                    protected void onFail(NetError error) {
                        getV().showError(error);
                    }

                    @Override
                    public void onNext(UserLoginReturn gankResults) {
//                        getV().showData(page, gankResults);
                    }
                });
    }
}
