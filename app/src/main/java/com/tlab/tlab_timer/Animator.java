package com.tlab.tlab_timer;

import android.view.View;
import android.view.animation.Interpolator;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class Animator {
        private  View view;
        private Interpolator interpolator;
        private  int duration;
        private android.os.Handler mHandler;
        private  int mInterval;
        private  float scaleX,scaleY;

        public  Animator(View view,Interpolator interpolator,int duration){
            this.view = view;
            this.interpolator = interpolator;
            this.duration = duration;
            this.mHandler = new android.os.Handler();
            this.mInterval = 3000;
            this.scaleX = view.getScaleX();
            this.scaleY = view.getScaleY();
        }

        Runnable mStatusChecker = new Runnable() {
            @Override
            public void run() {
                view.setAlpha(1f);
                view.setScaleX(scaleX);
                view.setScaleY(scaleY);
                view.animate().alpha(0f).setInterpolator(interpolator).setDuration(2000).start();
                view.animate().scaleX(2f).scaleY(2f).setInterpolator(interpolator).setDuration(4000).start();
                mHandler.postDelayed(mStatusChecker,mInterval);
            }
        };
        public void start(){
            mStatusChecker.run();
        }





}
