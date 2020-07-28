package com.liuyong.simplems.system.service.impl;

import com.liuyong.simplems.common.base.BaseServiceImpl;
import com.liuyong.simplems.system.dao.MenuMapper;
import com.liuyong.simplems.system.ent.Menu;
import com.liuyong.simplems.system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements MenuService {
    @Autowired
    MenuMapper menuMapper;

    @Override
    public List<Menu> listMenusByLevel() {
        List<Menu> allMenus = this.list();
        List<Menu> levelMenus = new ArrayList<>();
        for (int i = 0; i < allMenus.size(); i++) {
            Menu currentMenu = allMenus.get(i);
            if(currentMenu.getParentMenuId() == -1) {
                this.RecursiveChild(currentMenu, allMenus);
                levelMenus.add(currentMenu);
            }
        }
        return levelMenus;
    }

    public void RecursiveChild(Menu menu, List<Menu> allMenus) {
        List<Menu> childMenus = new ArrayList<>();
        for (int i = 0; i < allMenus.size(); i++) {
            Menu currentMenu = allMenus.get(i);
            if(menu.getId() == currentMenu.getParentMenuId()) {
                RecursiveChild(currentMenu, allMenus);
                childMenus.add(currentMenu);
            }
        }
        menu.setMenuList(childMenus);
    }
}
