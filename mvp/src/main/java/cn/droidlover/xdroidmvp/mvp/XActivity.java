package cn.droidlover.xdroidmvp.mvp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.tbruyelle.rxpermissions2.RxPermissions;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.Unbinder;
import cn.droidlover.xdroidmvp.XDroidConf;
import cn.droidlover.xdroidmvp.event.RxBus;
import cn.droidlover.xdroidmvp.kit.KnifeKit;
import cn.droidlover.xdroidmvp.net.NetError;

/**
 * Created by wanglei on 2016/12/29.
 */

public abstract class XActivity<P extends IPresent> extends RxAppCompatActivity implements IView<P> {

    private VDelegate vDelegate;
    private P p;
    protected Activity context;

    private RxPermissions rxPermissions;

    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;

        getP();

        if (getLayoutId() > 0) {
            setContentView(getLayoutId());
            bindUI(null);
            initEvent();
        }
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
    public void initEvent() {

    }


    @Override
    public void bindUI(View rootView) {
        unbinder = KnifeKit.bind(this);
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
    protected void onResume() {
        super.onResume();
        getvDelegate().resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        getvDelegate().pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
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
    public boolean onCreateOptionsMenu(Menu menu) {
        if (getOptionsMenuId() > 0) {
            getMenuInflater().inflate(getOptionsMenuId(), menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    protected RxPermissions getRxPermissions() {
        rxPermissions = new RxPermissions(this);
        rxPermissions.setLogging(XDroidConf.DEV);
        return rxPermissions;
    }

    @Override
    public int getOptionsMenuId() {
        return 0;
    }

}
