package fsx.heart.drawheart;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.Random;

/**
 * Created by dell 王世举 on 2016/12/25 21:20.
 */

public class HeartSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    // 画爱心的蝴蝶
    int[] heart_all = {R.mipmap.a1, R.mipmap.a2, R.mipmap.a3,
            R.mipmap.a4, R.mipmap.a5, R.mipmap.a6, R.mipmap.a7,
            R.mipmap.a8, R.mipmap.a9, R.mipmap.a10, R.mipmap.a11,
            R.mipmap.a12, R.mipmap.a13, R.mipmap.a14, R.mipmap.a15,
            R.mipmap.a16, R.mipmap.a17, R.mipmap.a18, R.mipmap.a19};
    Context mContext;
    // 图片软引用
    BitmapCache bitmapcache;

    private SurfaceHolder holder;
    private static final double radius = 13.5;//控制心的大小
    private static final double density = 0.2;//花的密度
//    private Thread shthread;  // 心

    int w;
    int h;

    public HeartSurfaceView(Context context, int s_w, int s_h) {
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
        Thread shthread = new ShowHeart(this.holder, "showback", this.w, this.h, 2.5f);
        Thread shthread2 = new ShowHeart(this.holder, "showback2", this.w, this.h, 1.8f);
        shthread.start();
        shthread2.start();
    }

    class ShowHeart extends Thread {
        private SurfaceHolder holder;
        int sh;
        int sw;
        float divisor;

        public ShowHeart(SurfaceHolder holder, String threadname, int sw, int sh, float divisor) {
            this.holder = holder;
            setName(threadname);
            this.sw = sw;
            this.sh = sh;
            this.divisor = divisor;
        }

        public void run() {
            this.holder.setKeepScreenOn(true);
//            run_hua_heart(4);
            run_hua_heart(divisor);
//            run_hua_heart(1.5f);
//            run_M_M();
        }

        /**
         * 画中间的心
         */
        private void run_hua_heart(float divisor) {
//            int startx = sw / 2 - 16, starty = sh / 2 - 68;
            int startx = (int) ((sw / divisor) - 16), starty = sh / 2 - 68;
            int maxh = 100;
            double begin = 10; // 起始位置
            Random rm = new Random();
            int old_num = -1;
            float old_xx = 0, old_yy = 0;
            Paint p = new Paint(); // 创建画笔
            p.setColor(Color.RED);
            for (int i = 0; i < maxh; i++) {
                try {
                    Thread.sleep(80);
                } catch (InterruptedException e1) {
                    // TODO 自动生成的 catch 块
                    e1.printStackTrace();
                }

                int hua_num = rm.nextInt(18);
                Bitmap bit = bitmapcache
                        .getBitmap(heart_all[hua_num], mContext);
                begin = begin + density; // 密度
                double b = begin / Math.PI;
                double a = radius * (16 * Math.pow(Math.sin(b), 3)); // 这里的13.5可以控制大小
                double d = -radius
                        * (13 * Math.cos(b) - 5 * Math.cos(2 * b) - 2
                        * Math.cos(3 * b) - Math.cos(4 * b));
                synchronized (holder) {
                    Canvas c = null;
                    try {
                        float xx = (float) a;
                        float yy = (float) d;

                        c = holder.lockCanvas(new Rect(
                                (int) (startx + xx - 40),
                                (int) (starty + yy - 40),
                                (int) (startx + xx + 40),
                                (int) (starty + yy + 40)));
//                        Paint p = new Paint(); // 创建画笔
//                        p.setColor(Color.RED);
                        // 画上一个，要不然会闪烁
                        if (old_num != -1) {
                            Bitmap bb = bitmapcache.getBitmap(
                                    heart_all[old_num], mContext);
                            c.drawBitmap(bb, startx + old_xx, starty + old_yy,
                                    p);
                        }
                        c.drawBitmap(bit, startx + xx, starty + yy, p);
                        old_num = hua_num;
                        old_xx = xx;
                        old_yy = yy;
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
