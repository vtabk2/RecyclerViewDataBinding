/*
 * Copyright (C) 2016 MarkZhai (http://zhaiyifan.cn).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tuananh.recyclerviewdatabinding.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.tuananh.recyclerviewdatabinding.BR;

import java.util.List;

/**
 * Base Data Binding RecyclerView Adapter.
 *
 * @author markzhai on 16/8/25
 */
public abstract class BaseViewAdapter<T> extends RecyclerView.Adapter<BindingViewHolder> {
    protected final LayoutInflater mLayoutInflater;
    protected List<T> mCollection;
    protected Presenter mPresenter;
    protected Decorator mDecorator;

    public BaseViewAdapter(Context context) {
        mLayoutInflater =
            (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {
        final Object item = mCollection.get(position);
        holder.getBinding().setVariable(BR.viewModel, item);
        holder.getBinding().setVariable(BR.listener, getPresenter());
        holder.getBinding().executePendingBindings();
        if (mDecorator != null) {
            mDecorator.decorator(holder, position, getItemViewType(position));
        }
    }

    @Override
    public int getItemCount() {
        return mCollection.size();
    }

    public void remove(int position) {
        mCollection.remove(position);
        notifyItemRemoved(position);
    }

    public void clear() {
        mCollection.clear();
        notifyDataSetChanged();
    }

    public void setDecorator(Decorator decorator) {
        mDecorator = decorator;
    }

    protected Presenter getPresenter() {
        return mPresenter;
    }

    public void setPresenter(Presenter presenter) {
        mPresenter = presenter;
    }

    public interface Presenter {
    }

    public interface Decorator {
        void decorator(BindingViewHolder holder, int position, int viewType);
    }
}
