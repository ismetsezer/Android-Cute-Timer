package com.tlab.tlab_timer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;

public class CircleInterpolator  implements Interpolator {


    @Override
    public float getInterpolation(float t) {
        float x=2.0f*t-1.0f;
        return 0.5f*(x*x*x + 1.0f);
    }
}
