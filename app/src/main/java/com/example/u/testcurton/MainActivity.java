package com.example.u.testcurton;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import de.keyboardsurfer.android.widget.crouton.Configuration;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button_top,button_no_top,button_custom;
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_top= (Button) findViewById(R.id.button_top);

        button_no_top= (Button) findViewById(R.id.button_no_top);

        button_custom= (Button) findViewById(R.id.button_customview);

        layout= (LinearLayout) findViewById(R.id.linearlayout);

        button_top.setOnClickListener(this);
        button_no_top.setOnClickListener(this);
        button_custom.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_top:
                //使用系统Style
                Crouton.makeText(MainActivity.this,button_top.getText(),Style.ALERT).show();
                break;
            case R.id.button_no_top:

                //                设置背景色，内容对齐方式，字体颜色，显示时长。
                Style style=new Style.Builder().setBackgroundColor(R.color.colorPrimaryDark)
                        .setGravity(Gravity.RIGHT)
                        .setTextColor(R.color.colorAccent)
                        .setConfiguration(new Configuration.Builder().setDuration(500).build())
                        .build();
                Crouton.makeText(MainActivity.this,button_no_top.getText(),style,layout).show();
                break;
            case R.id.button_customview:



                View custom= LayoutInflater.from(this).inflate(R.layout.customview,null);

                TextView tvTitle= (TextView) custom.findViewById(R.id.title);
                TextView tvSub= (TextView) custom.findViewById(R.id.subtitle);

                tvTitle.setText("Hello");

                tvSub.setText("World");

                Crouton.make(MainActivity.this,custom).show();
                break;
        }
    }
}
