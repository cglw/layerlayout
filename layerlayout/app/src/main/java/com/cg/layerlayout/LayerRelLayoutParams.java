package com.cg.layerlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by chengang on 2018/3/14.
 */

public class LayerRelLayoutParams extends RelativeLayout.LayoutParams {
    int layer = 0;

    public LayerRelLayoutParams(Context c, AttributeSet attrs) {
        super(c, attrs);
        TypedArray a = c.obtainStyledAttributes(attrs, R.styleable.LayerParams);
        //获取设置在子控件上的位置属性
        layer = a.getInt(R.styleable.LayerParams_layer, 0);
        a.recycle();
    }
    public LayerRelLayoutParams(int width, int height) {
        super(width, height);
    }

    public LayerRelLayoutParams(ViewGroup.LayoutParams source) {
        super(source);
    }


}
