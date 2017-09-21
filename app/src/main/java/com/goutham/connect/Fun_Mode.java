package com.goutham.connect;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Goutham on 19-09-2017.
 */

public class Fun_Mode extends MainActivity {

    int currPlayer=0;
    int[] coin={2,2,2,2,2,2,2,2,2};
    public void dropIn(View view) {

        ImageView disk = (ImageView) view;
        String number = disk.getTag().toString();
        System.out.println(number);
        int coinNumber = Integer.parseInt(number);
        if(coinNumber<=5)
            disk.setTranslationY(-1000f);
        else
            disk.setTranslationY(-3000f);

        //if (coin[coinNumber] == 2) {
        coin[coinNumber] = currPlayer;
        if (currPlayer == 0) {
            disk.setImageResource(R.drawable.rsz_yellows);
            currPlayer = 1;
        } else {
            disk.setImageResource(R.drawable.rsz_1red);
            currPlayer = 0;
            //coin[coinNumber] = currPlayer;
        }

        if(coinNumber<=5)
            disk.animate().translationYBy(1000f).rotation(300).setDuration(2500);
        else
            disk.animate().translationYBy(3000f).rotation(300).setDuration(2000);
        //}
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}


