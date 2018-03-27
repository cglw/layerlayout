package com.cg.layerlayout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * Created by chengang on 2018/3/14.
 *
 */

public class LayerLinearLayout extends LinearLayout {
    public LayerLinearLayout(Context context) {
        super(context);
        init();
    }

    private void init() {

    }

    public LayerLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayerLinLayoutParams(getContext(), attrs);
    }

    @Override
    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams lp) {
        return new LayerLinLayoutParams(lp);
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(LayerLinLayoutParams.WRAP_CONTENT, LayerLinLayoutParams.WRAP_CONTENT);
    }

    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof LayerLinLayoutParams;
    }

    View[] sortChildren = null;
    View[] starChildren = null;
    Field fieldChildren = null;


    public void orderChildrenByLayer() {
        View[] mChildren = null;
        int mChildrenCount = getChildCount();
        try {
            fieldChildren = this.getClass().getSuperclass().getSuperclass().getDeclaredField("mChildren");
            fieldChildren.setAccessible(true);
            // mChildren 默认长度是12
            mChildren = (View[]) fieldChildren.get(this);
            //保存绘制前的mChildren 为了绘制完恢复    mChildren
            starChildren = Arrays.copyOf(mChildren, mChildren.length);
            //根据layer 排序
            sortChildren = Arrays.copyOf(mChildren, mChildrenCount);
            Arrays.sort(sortChildren, new ViewComparator());
            //排序好的sortChildren，赋值给 mChildren,为了跟原长度一致
            fieldChildren.set(this, Arrays.copyOf(sortChildren, mChildren.length));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public void reSetChildren() {
        //恢复mChildren
        if (starChildren != null && fieldChildren != null) {
            try {
                fieldChildren.set(this, Arrays.copyOf(starChildren, starChildren.length));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        orderChildrenByLayer();
        super.dispatchDraw(canvas);
        reSetChildren();

    }



}
