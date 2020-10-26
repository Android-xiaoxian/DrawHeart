package fsx.heart.drawheart.other.view;

/**
 * @author FANG SHIXIAN
 * @date 2020/10/9.
 * description：
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * 自定义圆形seekBar，只支持固定宽度
 */
public class CircularSeekBar extends View {

    private int mViewWidth;//控件的宽
    private int mCurrentProgress = 40;//当前进度
    private int mMaxProgress = 100;//总进度
    private int mSeekBarCircularWidth = 6;//圆环的宽度
    private int mR;//半径
    private String mBgDefault = "#BDBDBD";//默认背景色
    private String mBgSeekBar = "#1db36f";//进度背景色
    private Paint mPaintDefault;
    private Paint mPaintSeekBar;
    private RectF rectFProgress;

    public CircularSeekBar(Context context) {
        super(context);
        init();
    }

    private void init() {
        mPaintDefault = new Paint();
        mPaintDefault.setStrokeWidth(mSeekBarCircularWidth);
        mPaintDefault.setAntiAlias(true);
        mPaintDefault.setColor(Color.parseColor(mBgDefault));
        mPaintDefault.setStyle(Paint.Style.STROKE);

        mPaintSeekBar = new Paint();
        mPaintSeekBar.setStrokeWidth(mSeekBarCircularWidth);
        mPaintSeekBar.setAntiAlias(true);
        mPaintSeekBar.setColor(Color.parseColor(mBgSeekBar));
        mPaintSeekBar.setStyle(Paint.Style.STROKE);

        rectFProgress = new RectF();//只初始化一次
    }

    public CircularSeekBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CircularSeekBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int cx = mViewWidth / 2;
        canvas.drawCircle(cx, cx, mR, mPaintDefault);
        int sweepAngle = mCurrentProgress * 360 / mMaxProgress;
        int left = mSeekBarCircularWidth / 2;
        int right = mViewWidth - left;
        rectFProgress.set(left, left, right, right);//减掉画笔的宽度
        canvas.drawArc(rectFProgress, -90, sweepAngle, false, mPaintSeekBar);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        mViewWidth = MeasureSpec.getSize(widthMeasureSpec);
        mR = (mViewWidth - mSeekBarCircularWidth) / 2;
        setMeasuredDimension(mViewWidth, mViewWidth);
    }
}