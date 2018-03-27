package com.cg.layerlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by chengang on 2018/3/14.
 */

public class LayerLinLayoutParams extends LinearLayout.LayoutParams {
    int layer = 0;

    public LayerLinLayoutParams(Context c, AttributeSet attrs) {
        super(c, attrs);
        TypedArray a = c.obtainStyledAttributes(attrs, R.styleable.LayerParams);
        //获取设置在子控件上的位置属性
        layer = a.getInt(R.styleable.LayerParams_layer, 0);
        a.recycle();
    }
    public LayerLinLayoutParams(int width, int height) {
        super(width, height);
    }

    public LayerLinLayoutParams(ViewGroup.LayoutParams source) {
        super(source);
    }


}
