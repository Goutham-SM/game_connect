package com.goutham.connect;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ClassicXO extends AppCompatActivity {

    int currPlayer=0;
    int[] coin={2,2,2,2,2,2,2,2,2};
    int[][] winStates={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void dropIn(View view) {

        ImageView disk = (ImageView) view;
        String number = disk.getTag().toString();
        System.out.println(number);
        int tapedCoin = Integer.parseInt(number);


        if (coin[tapedCoin] == 2) {
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

            if (tapedCoin <= 5)
                disk.animate().translationYBy(1000f).rotation(300).setDuration(2500);
            else
                disk.animate().translationYBy(3000f).rotation(300).setDuration(2000);

            for(int[] winPos:winStates)
            {
                TextView winMsg = (TextView) findViewById(R.id.editText);
                String s=winMsg.toString();
                if(coin[winPos[0]]==coin[winPos[1]]&&coin[winPos[1]]==coin[winPos[2]]&&coin[winPos[0]]!=2) {
                    if(coin[winPos[0]]==0){
                        Toast.makeText(ClassicXO.this, "YELLOW WINS!!!", Toast.LENGTH_LONG).show();
                        s="YELLOW WINS!!!";
                        winMsg.setText(s);}
                    else if (coin[winPos[0]]==1){
                        Toast.makeText(ClassicXO.this, "RED WINS!!!", Toast.LENGTH_LONG).show();
                        s="RED WINS!!!";
                        winMsg.setText(s);}

                    LinearLayout layout=(LinearLayout) findViewById(R.id.layout1);
                    layout.setVisibility(View.VISIBLE);

                }
            }
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
