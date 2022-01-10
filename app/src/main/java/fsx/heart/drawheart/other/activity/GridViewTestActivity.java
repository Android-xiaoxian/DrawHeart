package fsx.heart.drawheart.other.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;

import fsx.heart.drawheart.R;

/**
 * @author FANG SHIXIAN
 * @date 2020/11/20.
 * description：
 */
public class GridViewTestActivity extends Activity implements AdapterView.OnItemClickListener {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        initView();
    }

    String[] strings = new String[]{"1h", "2d", "3g", "4eh", "5wg", "6hd", "7ert", "8", "3", "1", "2", "3"};

    private void initView() {
        ListView gridView = findViewById(R.id.listView);

        gridView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return 10;
            }

            @Override
            public Object getItem(int position) {
                return strings[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View     view     = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid, null);
                TextView   button   = view.findViewById(R.id.btn);
                TextView textView = view.findViewById(R.id.txt);
                button.setText("" + position);
                textView.setText(strings[position]);
                return view;
            }
        });

        gridView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.e("onItemClick", " " + position);
    }
}
