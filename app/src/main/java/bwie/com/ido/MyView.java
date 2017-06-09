package bwie.com.ido;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.ScaleAnimation;

import static android.content.Context.WINDOW_SERVICE;

/**
 * Created by $USER_NAME on 2017/6/9.
 */

public class MyView extends View {

    private Paint paint;
    private Paint paint1;
    private int rn;
    private String content;
    private String title;
    private int size;
    private int color;
    private Rect rect;
    private Paint werite;
    private int width;
    private int height;
    float x = 1080 / 2;
    float y = 1776 / 2 - 200;

    public void setTitle(String title) {
        this.title = title;
    }

    public MyView(Context context) {
        this(context, null);
    }

    public MyView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.MyView);
        title = a.getString(R.styleable.MyView_titleText);
        size = a.getDimensionPixelSize(R.styleable.MyView_titleTextSize, 20);
        color = a.getColor(R.styleable.MyView_titleTextColor, Color.WHITE);
        a.recycle();


        rect = new Rect();
        werite = new Paint();
        werite.setAntiAlias(true);
        werite.setStyle(Paint.Style.FILL);
        werite.setColor(color);
        werite.setTextSize(size);

        werite.getTextBounds(title, 0, title.length(), rect);


        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
        paint1 = new Paint();
        paint1.setColor(Color.RED);
        paint1.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public int getRn() {
        return rn;
    }

    public void setRn(int rn) {
        this.rn = rn;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        WindowManager wm = (WindowManager) this.getContext().getSystemService(WINDOW_SERVICE);
        width = wm.getDefaultDisplay().getWidth();
        height = wm.getDefaultDisplay().getHeight();

        System.out.println(width + "------------" + height);

        int r = 300;
        if (rn!=300){
            paint.setColor(Color.BLACK);
        }
        canvas.drawCircle(x, y, r, paint);


        canvas.drawCircle(x, y, rn, paint1);
        System.out.println(x + "---------" + y);
//        getHeight() / 2 + rect.height() / 2
        canvas.drawText(title, x, y, werite);

    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                if (rn == 300) {
                    x = event.getX();
                    y = event.getY();


                    System.out.println("x=" + x);
                    System.out.println("y=" + y);
                    paint.setColor(Color.WHITE);
                    invalidate();

                }
//                if (x > rect.left && x < rect.right && y > rect.top && y < rect.bottom) {
//
//                }


                break;


        }
        return true;
    }
}
