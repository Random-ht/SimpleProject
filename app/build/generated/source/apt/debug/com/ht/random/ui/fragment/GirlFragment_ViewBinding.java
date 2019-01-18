// Generated code from Butter Knife. Do not modify!
package com.ht.random.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ht.random.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class GirlFragment_ViewBinding<T extends GirlFragment> implements Unbinder {
  protected T target;

  @UiThread
  public GirlFragment_ViewBinding(T target, View source) {
    this.target = target;

    target.girl = Utils.findRequiredViewAsType(source, R.id.girl, "field 'girl'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.girl = null;

    this.target = null;
  }
}
