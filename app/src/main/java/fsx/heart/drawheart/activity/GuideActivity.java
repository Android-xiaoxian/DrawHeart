package fsx.heart.drawheart.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import android.view.View;

import fsx.heart.drawheart.R;
import fsx.heart.drawheart.other.activity.GridViewTestActivity;
import fsx.heart.drawheart.other.activity.ImageViewTestActivity;
import fsx.heart.drawheart.other.activity.RecyclerViewTestActivity;
import fsx.heart.drawheart.other.activity.VerticalSeekBarActivity;

/**
 * @author FANG SHIXIAN
 * @date 2020/8/11.
 * description：
 */
public class GuideActivity extends Activity implements View.OnClickListener {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        findViewById(R.id.txt_1).setOnClickListener(this);
        findViewById(R.id.txt_2).setOnClickListener(this);
        findViewById(R.id.txt_3).setOnClickListener(this);
        findViewById(R.id.txt_4).setOnClickListener(this);
        findViewById(R.id.txt_5).setOnClickListener(this);
        startActivity(new Intent(GuideActivity.this, MainActivity.class));
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txt_1:
                startActivity(new Intent(GuideActivity.this, MainActivity.class));
                break;
            case R.id.txt_2:
                startActivity(new Intent(GuideActivity.this, VerticalSeekBarActivity.class));
                break;
            case R.id.txt_3:
                startActivity(new Intent(GuideActivity.this, RecyclerViewTestActivity.class));
                break;
            case R.id.txt_4:
                startActivity(new Intent(GuideActivity.this, ImageViewTestActivity.class));
                break;
            case R.id.txt_5:
                startActivity(new Intent(GuideActivity.this, GridViewTestActivity.class));
                break;
            default:
                break;
        }
    }
}
