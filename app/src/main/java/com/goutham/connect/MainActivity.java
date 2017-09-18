package com.goutham.connect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void dropIn(View view)
    {
        ImageView disk=(ImageView) view;
        disk.setTranslationY(-1000f);

        disk.setImageResource(R.drawable.rsz_yellows);
        disk.animate().translationYBy(1000f).rotation(300).setDuration(3000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
