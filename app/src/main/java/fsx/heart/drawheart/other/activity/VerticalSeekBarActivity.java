package fsx.heart.drawheart.other.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import fsx.heart.drawheart.R;
import fsx.heart.drawheart.other.view.VerticalSeekBar;

/**
 * @author FANG SHIXIAN
 * @date 2020/8/11.
 * description：
 */
public class VerticalSeekBarActivity extends Activity {

    private TextView        txt_progress;
    private VerticalSeekBar seekBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical_seek_bar);

        txt_progress = findViewById(R.id.txt_progress);
        seekBar = findViewById(R.id.bar_kk1);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar bar, int progress, boolean fromUser) {

                txt_progress.setText(progress + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(VerticalSeekBarActivity.this, "开始", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(VerticalSeekBarActivity.this, "结束", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
