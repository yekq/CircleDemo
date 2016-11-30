package ykq.demo.Circle;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

public class MainActivity extends AppCompatActivity {
    private CircleArcView arcView;

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d("test","onConfigurationChanged(Configuration newConfig)");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.d("test","onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState)");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("test","onRestoreInstanceState(Bundle savedInstanceState)");
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        Log.d("test","onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState)");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("test","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("test","onStop");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("test","onCreate");
        setContentView(R.layout.activity_main);
        arcView= (CircleArcView) findViewById(R.id.arcView);

//        ValueAnimator animator= ObjectAnimator.ofFloat(20,100);
//        animator.setDuration(1000*4);
//        animator.setInterpolator(new AccelerateDecelerateInterpolator());
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                float process = (float) animation.getAnimatedValue();
//                arcView.setProcess(process);
//                arcView.setScale(process/100f);
//                arcView.postInvalidate();
//            }
//        });
//        animator.start();

        testAnminationSet();
        arcView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testAnminationSet();
            }
        });
    }

    private void startAnimation()
    {
        final float maxProcess=360f;
        arcView.setMaxProcess(maxProcess);
        ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(arcView,"rotationY",50,150,maxProcess);
        objectAnimator.setDuration(1000*2);
        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float process = (float) animation.getAnimatedValue();
                arcView.setProcess(process);
                arcView.setScale(process/maxProcess);
                arcView.postInvalidate();
            }
        });
        objectAnimator.start();
    }

    private void testAnminationSet()
    {
        AnimatorSet set=new AnimatorSet();

        final float maxProcess=360f;
        arcView.setMaxProcess(maxProcess);
        ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(arcView,"rotationY",50,maxProcess);
        objectAnimator.setDuration(1000*2);
        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float process = (float) animation.getAnimatedValue();
                arcView.setProcess(process);
                arcView.setScale(process/maxProcess);
                arcView.postInvalidate();
            }
        });

        ObjectAnimator animatorY=ObjectAnimator.ofFloat(arcView,"rotationX",maxProcess,50);
        animatorY.setDuration(1000*2);
        animatorY.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float process = (float) animation.getAnimatedValue();
                arcView.setProcess(process);
                arcView.setScale(process/maxProcess);
                arcView.postInvalidate();
            }
        });
        //颜色
        ObjectAnimator translationUp = ObjectAnimator.ofInt(arcView,
                "backgroundColor", Color.RED, Color.BLUE, Color.GRAY,
                Color.GREEN);
        translationUp.setInterpolator(new DecelerateInterpolator());
        translationUp.setDuration(1500);
        translationUp.setRepeatCount(-1);
        /*
         * ArgbEvaluator：这种评估者可以用来执行类型之间的插值整数值代表ARGB颜色。
         * FloatEvaluator：这种评估者可以用来执行浮点值之间的插值。
         * IntEvaluator：这种评估者可以用来执行类型int值之间的插值。
         * RectEvaluator：这种评估者可以用来执行类型之间的插值矩形值。
         *
         * 由于本例是改变View的backgroundColor属性的背景颜色所以此处使用ArgbEvaluator
         */
        translationUp.setEvaluator(new ArgbEvaluator());

        set.play(objectAnimator).before(animatorY).with(translationUp);
        set.start();
    }
}
