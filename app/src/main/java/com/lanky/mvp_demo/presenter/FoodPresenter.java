package com.lanky.mvp_demo.presenter;

import com.lanky.mvp_demo.bean.FoodBean;
import com.lanky.mvp_demo.model.FoodModel;
import com.lanky.mvp_demo.model.I_Model;
import com.lanky.mvp_demo.view.I_View;

import java.util.List;

/**
 * LankyBin create on 2020/12/15
 */
public class FoodPresenter {
    private I_Model model;
    private I_View view;

    public FoodPresenter(I_View view){
        this.view = view;
        model = new FoodModel();
    }

    public void queryFood(){
        model.query(new I_Model.onQueryListener() {

            @Override
            public void onComplete(List<FoodBean> foodBeanList) {
                view.showList(foodBeanList);
            }
        });
    }

    public void addFood(FoodBean foodBean){
        model.add(foodBean, new I_Model.onAddListener() {
            @Override
            public void onComplete() {
                view.refreshList();
            }
        });
    }

    public void deleteFood(){
        model.delete(new I_Model.onDeleteListener() {
            @Override
            public void onComplete() {
                view.refreshList();
            }
        });
    }
}
