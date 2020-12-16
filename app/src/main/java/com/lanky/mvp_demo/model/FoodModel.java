package com.lanky.mvp_demo.model;

import com.lanky.mvp_demo.bean.FoodBean;

import java.util.ArrayList;
import java.util.List;

/**
 * LankyBin create on 2020/12/15
 */
public class FoodModel implements I_Model {
    private static List<FoodBean> foodBeanList = new ArrayList<>();

    static {
        foodBeanList.add(new FoodBean("f1", 20));
        foodBeanList.add(new FoodBean("f2", 40));
        foodBeanList.add(new FoodBean("f3", 55));
    }

    @Override
    public void query(onQueryListener listener) {
        if (listener != null) {
            listener.onComplete(foodBeanList);
        }
    }

    @Override
    public void add(FoodBean foodBean, onAddListener listener) {
        foodBeanList.add(foodBean);
        if (listener != null) {
            listener.onComplete();
        }
    }

    @Override
    public void delete(onDeleteListener listener) {
        if (foodBeanList.size() > 0) {
            foodBeanList.remove(foodBeanList.size() - 1);
        }
        if (listener != null) {
            listener.onComplete();
        }
    }
}
