package ykq.demo.Circle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private CircleArcView arcView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

//        Log.d("test",(a==b?"true":"false"));
        arcView.setProcess(50);
        arcView.setScale(0.5f);
//        ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(arcView,"scale",1,100);
//        objectAnimator.setDuration(1000*4);
//        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                arcView.setProcess((Float) animation.getAnimatedValue());
//                arcView.postInvalidate();
//                Log.d("test",animation.getAnimatedValue().toString());
//            }
//        });
//        objectAnimator.start();
    }
}
