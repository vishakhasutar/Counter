package com.hitesh.counter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_res ;
    Button btn_count;
    TextView tv_data;
    int count=0;
    public static final String USER_PREF = "USER_PREF" ;
    public static final String KEY_NAME = "KEY_NAME";
    SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        btn_res = (Button) findViewById(R.id.btn_res);
        btn_count= (Button) findViewById(R.id.btn_count);
        tv_data = (TextView) findViewById(R.id.tv_data);
        sp = getSharedPreferences(USER_PREF, Context.MODE_PRIVATE);


        btn_res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count=0;
                tv_data.setText("0");

            }
        });



        btn_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                tv_data.setText(String.valueOf(count));
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(KEY_NAME, count);


            }
        });
    }
}
