package com.goutham.connect;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ClassicXO extends AppCompatActivity implements  View.OnClickListener{



    int currPlayer=0;
    int[] coin={2,2,2,2,2,2,2,2,2};
    int[][] winStates={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int flag=0;
    public void dropIn(View view) {

        ImageView disk = (ImageView) view;
        String number = disk.getTag().toString();
        //System.out.println(number);
        int tapedCoin = Integer.parseInt(number);


        if (coin[tapedCoin] == 2&&flag==0) {
            coin[tapedCoin] = currPlayer;
            if (tapedCoin <= 5)
                disk.setTranslationY(-1000f);
            else
                disk.setTranslationY(-3000f);


            if (currPlayer == 0) {
                disk.setImageResource(R.drawable.rsz_yellows);
                currPlayer = 1;
            } else {
                disk.setImageResource(R.drawable.rsz_1red);
                currPlayer = 0;
                //coin[coinNumber] = currPlayer;
            }

            //disk.animate().setUpdateListener(1000f);
           // System.out.println(tapedCoin);
            if (tapedCoin <= 5)
                disk.animate().translationYBy(1000f).rotation(300).setDuration(1500);
            else
                disk.animate().translationYBy(3000f).rotation(300).setDuration(2000);
            System.out.println(disk.getAnimation());
            TextView winMsg = (TextView) findViewById(R.id.editText);
            String s = winMsg.toString();

            for(int[] winPos:winStates) {

                if (coin[winPos[0]] == coin[winPos[1]] && coin[winPos[1]] == coin[winPos[2]] && coin[winPos[0]] != 2) {
                    if (coin[winPos[0]] == 0) {
                        Toast.makeText(ClassicXO.this, "YELLOW WINS!!!", Toast.LENGTH_LONG).show();
                        s = "YELLOW WINS!!!";
                        winMsg.setText(s);
                        flag = 1;
                        break;
                    } else if (coin[winPos[0]] == 1) {
                        Toast.makeText(ClassicXO.this, "RED WINS!!!", Toast.LENGTH_LONG).show();
                        s = "RED WINS!!!";
                        winMsg.setText(s);
                        flag = 1;
                        break;
                    }
                }
            }
                    int count=0;
                    for(int coins:coin)
                    {
                        if(coins!=2)
                            count++;
                        //System.out.println(coins);
                    }
                    if(count==9&&flag!=1){
                        s="There Is no winner!Try Again";
                        Toast.makeText(ClassicXO.this, "There Is no winner!Try Again" , Toast.LENGTH_LONG).show();
                        winMsg.setText(s);
                        flag=1;
                    }
                    if(flag==1) {
                        LinearLayout layout = (LinearLayout) findViewById(R.id.layout1);
                        layout.setVisibility(View.VISIBLE);

                    }


        }

    }


    public void reset(View view){
        LinearLayout lay =(LinearLayout) findViewById(R.id.layout1);
        lay.setVisibility(View.INVISIBLE);

        currPlayer=0;
        flag=0;
        for(int i=0;i<coin.length;i++)
            coin[i]=2;

        GridLayout grid = (GridLayout) findViewById(R.id.table);

        for(int i=0;i<grid.getChildCount();i++)
        {
            ((ImageView) grid.getChildAt(i)).setImageResource(0);
            ( grid.getChildAt(i)).animate().rotation(0);

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
        Intent i=new Intent(ClassicXO.this,StartPage.class);
        startActivity(i);

    }
}
