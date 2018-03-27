package com.cg.layerlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View viewById = findViewById(R.id.view2);

        LayerLinLayoutParams layoutParams = (LayerLinLayoutParams) viewById.getLayoutParams();
        layoutParams.layer=0;
    }
}
