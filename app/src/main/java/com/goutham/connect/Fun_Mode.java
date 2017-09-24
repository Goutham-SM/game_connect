package com.goutham.connect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Goutham on 19-09-2017.
 */

public class Fun_Mode extends MainActivity implements View.OnClickListener{

    int currPlayer = 0;
    int[] coin = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winStates = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    int flag=0;
    public void dropIn(View view) {

        ImageView disk = (ImageView) view;
        String number = disk.getTag().toString();
        System.out.println(number);
        int coinNumber = Integer.parseInt(number);
        if (coinNumber <= 5)
            disk.setTranslationY(-1000f);
        else
            disk.setTranslationY(-3000f);
        if(flag==0) {
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

            if (coinNumber <= 5)
                disk.animate().translationYBy(1000f).rotation(300).setDuration(1500);
            else
                disk.animate().translationYBy(3000f).rotation(300).setDuration(2000);
            //}
        }
        TextView winMsg = (TextView) findViewById(R.id.editText);
        String s = winMsg.toString();
        for (int[] winPos : winStates) {

            if (coin[winPos[0]] == coin[winPos[1]] && coin[winPos[1]] == coin[winPos[2]] && coin[winPos[0]] != 2) {
                if (coin[winPos[0]] == 0) {
                    Toast.makeText(Fun_Mode.this, "YELLOW WINS!!!", Toast.LENGTH_LONG).show();
                    s = "YELLOW WINS!!!";
                    winMsg.setText(s);
                    flag = 1;

                } else if (coin[winPos[0]] == 1) {
                    Toast.makeText(Fun_Mode.this, "RED WINS!!!", Toast.LENGTH_LONG).show();
                    s = "RED WINS!!!";
                    winMsg.setText(s);
                    flag = 1;

                }
            }
        }
        int count=0;
        for(int coins:coin)
        {
            if(coins!=2)
                count++;
            System.out.println(coins);
        }
        if(count==9){
            s="There Is no winner!Try Again";
            Toast.makeText(Fun_Mode.this, "There Is no winner!Try Again" , Toast.LENGTH_LONG).show();
            winMsg.setText(s);
            flag=1;
        }
                if(flag==1) {
                    LinearLayout layout = (LinearLayout) findViewById(R.id.layout1);
                    layout.setVisibility(View.VISIBLE);

                }



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn=(Button) findViewById(R.id.button10);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i=new Intent(Fun_Mode.this,StartPage.class);
        startActivity(i);

    }
}



