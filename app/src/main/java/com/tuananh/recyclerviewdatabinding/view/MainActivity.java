package com.tuananh.recyclerviewdatabinding.view;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.tuananh.recyclerviewdatabinding.R;
import com.tuananh.recyclerviewdatabinding.databinding.ActivityMainBinding;
import com.tuananh.recyclerviewdatabinding.model.Contacts;
import com.tuananh.recyclerviewdatabinding.recyclerview.BaseViewAdapter;
import com.tuananh.recyclerviewdatabinding.recyclerview.SingleTypeAdapter;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;
    private ObservableList<Contacts> mContactsList = new ObservableArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadData();
        initViews();
        updateAdapter();
    }

    private void loadData() {
        for (int i = 0; i < 10; i++) {
            mContactsList
                .add(new Contacts("abc " + i, "Framgia", "0964980253", "abc@gmail.com", "Family"));
        }
    }

    private void updateAdapter() {
        SingleTypeAdapter<Contacts> adapter =
            new SingleTypeAdapter<>(this, R.layout.item_recycler_contact);
        // add viewModels
        adapter.addAll(mContactsList);
        // add listener
        adapter.setPresenter(new ItemAdapterClickListener());
        mBinding.setLayoutManager(new LinearLayoutManager(this));
        mBinding.setAdapter(adapter);
    }

    private void initViews() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    public class ItemAdapterClickListener implements BaseViewAdapter.Presenter {
        public void onItemClick(String values) {
            Toast.makeText(getApplicationContext(), values, Toast.LENGTH_SHORT).show();
        }
    }
}
