package com.tlab.tlab_timer;

import android.icu.util.TimeZone;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {


    private Button circle;
    private TextView time;
    private Handler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        circle = findViewById(R.id.circle);
        time = findViewById(R.id.time);
        mHandler = new Handler();

        //Set time

        //For Button Animation, We wrote small animator class
        Animator animator = new Animator(circle,new CircleInterpolator(),4000);
        animator.start();
        //
        mTimeChecker.run();
    }

    Runnable mTimeChecker = new Runnable() {
        @Override
        public void run() {
            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            Date date  = new Date();
            time.setText(dateFormat.format(date));
            mHandler.postDelayed(mTimeChecker,1000);
        }
    };
}
