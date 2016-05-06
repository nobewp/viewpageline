package nobe.viewpageline;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class ScrollerTabView extends View {

    private int mTabNum;

    private float mWidth, mTabWidth, mOffset;

    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private int mBeginColor;

    private int mEndColor;

    private int sapce = 0;

    private RectF oval2;

    public ScrollerTabView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.ScrollerTabView);

         mBeginColor = typedArray.getColor(R.styleable.ScrollerTabView_beiginColor,
                0XFFFFFFFF);
        mEndColor = typedArray.getColor(R.styleable.ScrollerTabView_endColor,
                0XFFFFFFFF);
    }

    public void setTabNum(int n) {
        mTabNum = n;
    }

    public void setCurrentNum(int n) {
        mOffset = 0;
    }

    public void setOffset(int position, float offset) {
        if (offset == 0) {
            return;
        }
        mOffset = offset;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mTabWidth == 0) {
            mWidth = getWidth();
            mTabWidth = mWidth / mTabNum;
        }
        float left =  mOffset * mTabWidth;
        final float right = left + mTabWidth;
        final float top = getPaddingTop();
        final float bottom = getHeight() - getPaddingBottom();

        //canvas.drawRect(left + sapce, top, right - sapce, bottom, mPaint);
        if (oval2 == null) {
            oval2 = new RectF(left + sapce, top, right - sapce, bottom);
        } else {
            oval2.set(left + sapce, top, right - sapce, bottom);
        }
        mPaint.setColor(mBeginColor);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawRoundRect(oval2, 0, 0, mPaint);
    }

//    public void setSelectedColor(int color, int color2) {
//        mBeginColor = color;
//        mEndColor = color2;
//
//    }

    public void setSpace(int len) {
        sapce = len;
    }
}