package com.cg.layerlayout;

import android.view.View;
import android.view.ViewGroup;

import java.util.Comparator;

/**
 * Created by chengang on 2018/3/27.
 */

public class ViewComparator implements Comparator<View> {


    @Override
    //实现Comparator的compare方法
    public int compare(View view1, View view2) {

        ViewGroup.LayoutParams layoutParams = view1.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
        int view1_layer = 0, view2_layer = 0;
        if (layoutParams instanceof LayerRelLayoutParams) {
            view1_layer = ((LayerRelLayoutParams) layoutParams).layer;
        } else if (layoutParams instanceof LayerLinLayoutParams) {
            view1_layer = ((LayerLinLayoutParams) layoutParams).layer;
        }
        if (layoutParams2 instanceof LayerRelLayoutParams) {
            view2_layer = ((LayerRelLayoutParams) layoutParams2).layer;
        } else if (layoutParams instanceof LayerLinLayoutParams) {
            view2_layer = ((LayerLinLayoutParams) layoutParams2).layer;

        }
        // TODO Auto-generated method stub
        return view1_layer - view2_layer;
    }

}

