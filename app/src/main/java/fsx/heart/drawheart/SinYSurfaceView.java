package fsx.heart.drawheart;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.Random;

/**
 * Created by dell 王世举 on 2016/12/25 21:20.
 */

public class SinYSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    // 画爱心的蝴蝶
    int[] heart_all = {R.mipmap.a1,
            R.mipmap.a2,
            R.mipmap.a3,
            R.mipmap.a4,
            R.mipmap.a5,
            R.mipmap.a6,
            R.mipmap.a7,
            R.mipmap.a8,
            R.mipmap.a9,
            R.mipmap.a10,
            R.mipmap.a11,
            R.mipmap.a12,
            R.mipmap.a13,
            R.mipmap.a14,
            R.mipmap.a15,
            R.mipmap.a16,
            R.mipmap.a17,
            R.mipmap.a18,
            R.mipmap.a19};
    Context mContext;
    // 图片软引用
    BitmapCache bitmapcache;

    private SurfaceHolder holder;
    private static final double radius = 13.5;//控制心的半径大小
    private static final double density = 0.2;//花的密度
//    private Thread shthread;  // 心

    int w;
    int h;

    public SinYSurfaceView(Context context, int s_w, int s_h) {
        super(context);
        this.setFocusable(true);
        this.setKeepScreenOn(true);
        mContext = context;
        this.w = s_w;
        this.h = s_h;
        this.bitmapcache = BitmapCache.getInstance();
        this.holder = getHolder();
        this.holder.addCallback(this);
        // 透明
        setZOrderOnTop(true);
        holder.setFormat(PixelFormat.TRANSPARENT);
    }

    public SinYSurfaceView(Context context) {
        super(context);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        showHeart();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    public void showHeart() // 画心
    {
        Thread shThread = new ShowHeart(this.holder, "showback", this.w, this.h, 2f, 2);
        Thread shThread2 = new ShowHeart(this.holder, "showback2", this.w, this.h, 4f, 4f);
        Thread shThread3 = new ShowHeart(this.holder, "showback2", this.w, this.h, 0.75f, 0.75f);
        shThread.start();
//        shThread2.start();
//        shThread3.start();
    }

    class ShowHeart extends Thread {
        private SurfaceHolder holder;
        int sh;
        int sw;
        float xDivisor;
        float yDivisor;

        public ShowHeart(SurfaceHolder holder, String threadname, int sw, int sh, float xDivisor, float yDivisor) {
            this.holder = holder;
            setName(threadname);
            this.sw = sw;
            this.sh = sh;
            this.xDivisor = xDivisor;
            this.yDivisor = yDivisor;
        }

        public void run() {
            this.holder.setKeepScreenOn(true);
//            run_hua_heart(4, 4);
            run_hua_heart(xDivisor, yDivisor);
//            run_hua_heart(1.33f, 1.33f);
        }

        /**
         * 画中间的心
         *
         * @param xDivisor 控件宽度/divisor = 心的中心点(X轴)
         * @param yDivisor 控件宽度/divisor = 心的中心点（Y轴）
         */
        private void run_hua_heart(float xDivisor, float yDivisor) {
            Random rm = new Random();
            int old_num = -1;
            float old_xx = 0, old_yy = 0;
            Paint p = new Paint(); // 创建画笔
            p.setColor(Color.RED);

            float y = 0;

            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                try {
                    if (y >= sh) {
                        break;
                    }
                    Thread.sleep(70);
                } catch (InterruptedException e1) {
                    // TODO 自动生成的 catch 块
                    e1.printStackTrace();
                }
                int hua_num = rm.nextInt(18);
                Bitmap bit = bitmapcache
                        .getBitmap(heart_all[hua_num], mContext);
                float x = sw / 2 + (float) Math.sin(y / (sh / 64)) * 100;
                synchronized (holder) {
                    Canvas c = null;
                    try {

                        c = holder.lockCanvas(new Rect(
                                (int) (x - 40),
                                (int) (y - 40),
                                (int) (x + 40),
                                (int) (y + 40)));

                        // 画上一个，要不然会闪烁
                        if (old_num != -1) {
                            Bitmap bb = bitmapcache.getBitmap(
                                    heart_all[old_num], mContext);
                            c.drawBitmap(bb, old_xx, old_yy, p);
                        }

                        c.drawBitmap(bit, x, y, p);
                        old_num = hua_num;
                        old_xx = x;
                        old_yy = y;
                        y += 10;
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            if (c != null) {
                                holder.unlockCanvasAndPost(c);// 结束锁定画图，并提交改变。
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

}
