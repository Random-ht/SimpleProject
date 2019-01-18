package cn.droidlover.xdroidmvp.mvp;

import android.os.Bundle;
import android.view.View;

import cn.droidlover.xdroidmvp.net.NetError;

/**
 * Created by wanglei on 2016/12/29.
 */

public interface IView<P> {
    void bindUI(View rootView);//使用ButterKnife绑定控件

    void initEvent();//当需要使用EventBus的时候调用

    void initData(Bundle savedInstanceState);

    int getOptionsMenuId();//右上角的item

    int getLayoutId();//获取布局

    P newP();//获取present

    void showError(NetError error);

}
