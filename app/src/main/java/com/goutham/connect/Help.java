package com.goutham.connect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Goutham on 21-09-2017.
 */

public class Help extends MainActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_page);
        Button btn = (Button) findViewById(R.id.but2);
        btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View v)
    {
        Intent i=new Intent(Help.this,MainActivity.class);
        startActivity(i);

    }

}
