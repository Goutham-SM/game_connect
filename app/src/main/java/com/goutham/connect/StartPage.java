package com.goutham.connect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Goutham on 21-09-2017.
 */

public class StartPage extends MainActivity implements View.OnClickListener{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mode_selection);
        Button one = (Button) findViewById(R.id.button5);
        one.setOnClickListener(this);
        Button two = (Button) findViewById(R.id.button6);
        two.setOnClickListener(this);
        Button three = (Button) findViewById(R.id.button7);
        three.setOnClickListener(this);
        Button four = (Button) findViewById(R.id.button8);
        four.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        Intent i;
        switch (v.getId())
        {
            case R.id.button5 :
                i=new Intent(StartPage.this,ClassicXO.class);
                startActivity(i);

                break;
            case R.id.button6 :
                i=new Intent(StartPage.this,Fun_Mode.class);
                startActivity(i);

                break;
            case R.id.button7 :
                i=new Intent(StartPage.this,Fun_Mode.class);
                startActivity(i);

                break;
            case R.id.button8 :
                i=new Intent(StartPage.this,MainActivity.class);
                startActivity(i);

                break;
        }
    }
}
