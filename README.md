# layerlayout
可控制布局绘制的层次的Viewgroup,基于Linearlayout,Relativelayout
通过设置view的layer 值 更改布局绘制层次

### gradle dependency:
```
compile 'com.cg:layerlayout:0.0.1'
```

### 使用方法
以下是可控制图层的Linearlayout的使用，其他自定义的同理，layer值相同按照所在viewgroup的先后顺序绘制，不一致则按照layer大小决定绘制先后顺序，值小的先绘制，默认视图layer为0

1.xml使用
```
 <com.cg.layerlayout.LayerLinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <View
            android:layout_width="200dp"
            android:layout_height="200dp"
            android:background="#6600ff00"
            app:layer="2"/>

        <View
            android:id="@+id/view2"
            android:layout_marginTop="-50dp"
            android:layout_width="200dp"
            android:layout_height="200dp"
            android:background="#000"
            app:layer="1"/>
</com.cg.layerlayout.LayerLinearLayout>
```
2.code中使用
```
   LayerLinLayoutParams layoutParams = (LayerLinLayoutParams) viewById.getLayoutParams();
    layoutParams.layer=0;

```
