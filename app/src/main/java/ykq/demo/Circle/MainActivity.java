package ykq.demo.Circle;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private CircleArcView arcView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arcView= (CircleArcView) findViewById(R.id.arcView);
        ValueAnimator animator=ValueAnimator.ofFloat(0,100);
        animator.setDuration(2000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                arcView.setProcess((Float) animation.getAnimatedValue());
            }
        });
        animator.start();
    }
}
