package fsx.heart.drawheart.other.adapter;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import fsx.heart.drawheart.R;

/**
 * @author FANG SHIXIAN
 * @date 2020/9/8.
 * description：
 */
public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View       view   = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_test, null);
        ViewHolder holder = new ViewHolder(view);

        Drawable.ConstantState a1 = holder.imageView.getDrawable().getConstantState();
        Log.d("tag0", "onCreateViewHolder" + a1);
        Drawable.ConstantState a2 = ContextCompat
                .getDrawable(parent.getContext(), R.drawable.a2)
                .getConstantState();
        Log.e("tag1", "onCreateViewHolder" + a2);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (position % 2 == 0) {
            holder.imageView.setImageResource(R.drawable.a2);
        } else {
            holder.imageView.setImageResource(R.drawable.a3);
        }

        Drawable.ConstantState a = holder.imageView.getDrawable().getConstantState();
        Log.d("tag", "onBindViewHolder" + a);
    }

    @Override
    public int getItemCount() {
        return 100;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
