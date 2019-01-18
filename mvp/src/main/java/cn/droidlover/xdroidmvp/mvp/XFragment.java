package cn.droidlover.xdroidmvp.mvp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tbruyelle.rxpermissions2.RxPermissions;
import com.trello.rxlifecycle2.components.support.RxFragment;

import butterknife.Unbinder;
import cn.droidlover.xdroidmvp.XDroidConf;
import cn.droidlover.xdroidmvp.event.RxBus;
import cn.droidlover.xdroidmvp.kit.KnifeKit;
import cn.droidlover.xdroidmvp.net.NetError;

/**
 * Created by wanglei on 2016/12/29.
 */

public abstract class XFragment<P extends IPresent> extends RxFragment implements IView<P> {

    private VDelegate vDelegate;
    private P p;
    protected Activity context;
    private View rootView;
    protected LayoutInflater layoutInflater;

    private RxPermissions rxPermissions;

    private Unbinder unbinder;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layoutInflater = inflater;
        if (rootView == null && getLayoutId() > 0) {
            rootView = inflater.inflate(getLayoutId(), null);
            bindUI(rootView);
        } else {
            ViewGroup viewGroup = (ViewGroup) rootView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(rootView);
            }
        }

        return rootView;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getP();
        initEvent();
        initData(savedInstanceState);
        setNext();
    }

    protected void setNext() {

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

    @Override
    public void bindUI(View rootView) {
        unbinder = KnifeKit.bind(this, rootView);
    }


    protected VDelegate getvDelegate() {
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
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            this.context = (Activity) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        context = null;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void initEvent() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
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
