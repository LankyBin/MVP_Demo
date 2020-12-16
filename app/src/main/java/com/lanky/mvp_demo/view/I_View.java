package com.lanky.mvp_demo.view;

import com.lanky.mvp_demo.bean.FoodBean;

import java.util.List;

/**
 * LankyBin create on 2020/12/15
 */
public interface I_View {
    void showList(List<FoodBean> foodBeanList);
    void refreshList();
}
