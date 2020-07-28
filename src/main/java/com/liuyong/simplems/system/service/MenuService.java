package com.liuyong.simplems.system.service;

import com.liuyong.simplems.common.base.BaseService;
import com.liuyong.simplems.system.ent.Menu;

import java.util.List;

public interface MenuService extends BaseService<Menu> {
    List<Menu> listMenusByLevel();
    void RecursiveChild(Menu menu, List<Menu> allMenus);
}
