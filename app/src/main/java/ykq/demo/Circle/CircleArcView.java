package ykq.demo.Circle;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * <br/>
 * Created on 2016/5/3
 *
 * @author yekangqi
 */
public class CircleArcView extends View{
    private Paint paint;
    private float strokeWidth=20;//外环直径
    private RectF strokeRectF;//外环画板
    private float endAngle=360;//环形总度数
    private float centreCircleRadius=300;//内圆半径
    private float process;//1~100
    public CircleArcView(Context context) {
        super(context);
        init(context,null);
    }

    public CircleArcView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public CircleArcView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CircleArcView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context,attrs);
    }

    private void init(Context context, AttributeSet attrs)
    {
        paint=new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(strokeWidth);
    }

    public void setProcess(float process)
    {
        this.process=process;
        postInvalidate();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);//半径内包含一半stroke

        //外环
        float r=Math.min(getWidth(),getHeight());
        float tempPro=(process/100f);
        Log.d("test","pro:"+tempPro);
        strokeRectF = new RectF(strokeWidth/2f*tempPro,strokeWidth/2f*tempPro, r-strokeWidth/2f*tempPro,r-strokeWidth/2f*tempPro);//包含一半stroke(要考虑边距)
        canvas.drawArc(strokeRectF, 0, endAngle*tempPro, false, paint);//弧形所在矩形区域、起始角度、圆弧扫过的角度(顺时针方向，单位为度,从右中间开始为零度)、是否包括圆心（是：扇形圆弧；否：外层圆弧）、画笔
        //内圆
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        float radius=centreCircleRadius*(process/100);
        float maxRadius=r/2f-strokeWidth;
        if (radius>maxRadius)
        {
            radius=maxRadius;
        }
        canvas.drawCircle(r/2,r/2,radius,paint);
    }
}
