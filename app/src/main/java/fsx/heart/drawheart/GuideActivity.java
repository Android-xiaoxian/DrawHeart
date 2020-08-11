package fsx.heart.drawheart;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.txt_1:
                startActivity(new Intent(GuideActivity.this,MainActivity.class));
                break;
            case R.id.txt_2:
                startActivity(new Intent(GuideActivity.this, VerticalSeekBarActivity.class));
                break;
            default:
                break;
        }
    }
}
