package fsx.heart.drawheart.other.activity;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import fsx.heart.drawheart.R;
import fsx.heart.drawheart.other.adapter.TestAdapter;

/**
 * @author FANG SHIXIAN
 * @date 2020/9/8.
 * description：
 */
public class RecyclerViewTestActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_test);
        initView();
    }


    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        TestAdapter adapter = new TestAdapter();
        recyclerView.setAdapter(adapter);
    }
}
