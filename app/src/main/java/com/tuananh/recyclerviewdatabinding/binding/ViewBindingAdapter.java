package com.tuananh.recyclerviewdatabinding.binding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

public class ViewBindingAdapter {
    @BindingAdapter("layoutManager")
    public static void setLayoutManager(RecyclerView view, RecyclerView.LayoutManager manager) {
        view.setLayoutManager(manager);
    }

    @BindingAdapter("adapter")
    public static void setAdapter(RecyclerView view, RecyclerView.Adapter adapter) {
        view.setAdapter(adapter);
    }
}
