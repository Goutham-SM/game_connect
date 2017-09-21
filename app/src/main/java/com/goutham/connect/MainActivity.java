package com.goutham.connect;

import android.app.Activity;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId())
        {
            case R.id.button2:
                i=new Intent(MainActivity.this,StartPage.class);
                startActivity(i);


                break;
            case R.id.button3:
                i=new Intent(MainActivity.this,Help.class);
                startActivity(i);



                break;
            case R.id.button4:
                //finish();
                System.exit(0);
        }
    }
}
