package com.lanky.mvp_demo.model;

import com.lanky.mvp_demo.bean.FoodBean;

import java.util.List;

/**
 * LankyBin create on 2020/12/15
 */
public interface I_Model {
    void query(onQueryListener listener);
    void add(FoodBean foodBean, onAddListener listener);
    void delete(onDeleteListener listener);

    interface onQueryListener {
        void onComplete(List<FoodBean> foodBeanList);
    }
    interface onAddListener {
        void onComplete();
    }
    interface onDeleteListener {
        void onComplete();
    }
}
