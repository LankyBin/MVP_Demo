package com.lanky.mvp_demo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.lanky.mvp_demo.R;
import com.lanky.mvp_demo.adapter.FoodAdapter;
import com.lanky.mvp_demo.bean.FoodBean;
import com.lanky.mvp_demo.presenter.FoodPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,I_View {
    private final String TAG = "lanky";

    private ListView mListView;
    private Button btn_add;
    private Button btn_delete;

    private FoodAdapter foodAdapter;
    private FoodPresenter foodPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        foodPresenter = new FoodPresenter(this);
        foodPresenter.queryFood();
    }

    private void initView() {
        mListView = findViewById(R.id.lv);
        btn_add = findViewById(R.id.bt_add);
        btn_delete = findViewById(R.id.bt_delete);
        btn_add.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_add:
                FoodBean foodBean = new FoodBean("hahah",30);
                foodPresenter.addFood(foodBean);
                break;
            case R.id.bt_delete:
                foodPresenter.deleteFood();
                break;
        }
    }

    @Override
    public void showList(List<FoodBean> foodBeanList) {
        foodAdapter = new FoodAdapter(MainActivity.this, foodBeanList);
        mListView.setAdapter(foodAdapter);
    }

    @Override
    public void refreshList() {
        foodAdapter.notifyDataSetChanged();
    }
}