package cn.droidlover.xdroidmvp.mvp;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.tbruyelle.rxpermissions2.RxPermissions;

import butterknife.Unbinder;
import cn.droidlover.xdroidmvp.XDroidConf;
import cn.droidlover.xdroidmvp.event.RxBus;
import cn.droidlover.xdroidmvp.kit.KnifeKit;
import cn.droidlover.xdroidmvp.net.NetError;

/**
 * Created by wanglei on 2017/1/26.
 */

public abstract class XLazyFragment<P extends IPresent>
        extends LazyFragment implements IView<P> {

    private VDelegate vDelegate;
    private P p;

    private RxPermissions rxPermissions;
    private Unbinder unbinder;

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);

        getP();

        if (getLayoutId() > 0) {
            setContentView(getLayoutId());
            bindUI(getRealRootView());
            initEvent();
        }

        initData(savedInstanceState);

        setNext();
    }

    protected void setNext() {

    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void bindUI(View rootView) {
        unbinder = KnifeKit.bind(this, rootView);
    }

    @Override
    public void initEvent() {

    }

    public VDelegate getvDelegate() {
        if (vDelegate == null) {
            vDelegate = VDelegateBase.create(context);
        }
        return vDelegate;
    }

    protected P getP() {
        if (p == null) {
            p = newP();
            if (p != null) {
                p.attachV(this);
            }
        }
        return p;
    }

    @Override
    protected void onDestoryLazy() {
        super.onDestoryLazy();
        if (RxBus.getDefault() != null) {
            RxBus.getDefault().unregister(this);
        }
        if (getP() != null) {
            getP().detachV();
        }
        getvDelegate().destory();

        p = null;
        vDelegate = null;
    }

    @Override
    public void showError(NetError error) {
        String error_msg = "";
        if (error != null) {
            switch (error.getType()) {
                case NetError.ParseError:
                    error_msg = "数据解析异常";
                    break;
                case NetError.AuthError:
                    error_msg = "身份验证异常";
                    break;
                case NetError.BusinessError:
                    error_msg = "业务异常";
                    break;
                case NetError.NoConnectError:
                    error_msg = "网络无连接";
                    break;
                case NetError.NoDataError:
                    error_msg = "数据为空";
                    break;
                case NetError.OtherError:
                    error_msg = "其他异常";
                    break;
            }
            Toast.makeText(context, error_msg, Toast.LENGTH_SHORT).show();
        }
    }

    protected RxPermissions getRxPermissions() {
        rxPermissions = new RxPermissions(getActivity());
        rxPermissions.setLogging(XDroidConf.DEV);
        return rxPermissions;
    }

    @Override
    public int getOptionsMenuId() {
        return 0;
    }

}
