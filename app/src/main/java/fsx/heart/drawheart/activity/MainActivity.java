package fsx.heart.drawheart.activity;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import fsx.heart.drawheart.view.HeartSurfaceView;
import fsx.heart.drawheart.R;

public class MainActivity extends AppCompatActivity {

    FrameLayout      f1;
    HeartSurfaceView fr;

    LinearLayout l1;
    private Context mContext;
    private int screen_h;
    private int screen_w;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Display localDisplay = getWindowManager().getDefaultDisplay();
        this.screen_w = localDisplay.getWidth();
        this.screen_h = localDisplay.getHeight();

        f1 = ((FrameLayout) findViewById(R.id.f1));
        l1 = ((LinearLayout) findViewById(R.id.l1));

        this.fr = new HeartSurfaceView(this, this.screen_w, this.screen_h);
        this.f1.removeAllViews();
        this.f1.addView(this.fr, new ViewGroup.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT));
//        fr.showHeart();
    }
}
