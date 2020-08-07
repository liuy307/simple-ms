package com.liuyong.simplems.system.service;

import com.liuyong.simplems.common.base.BaseService;
import com.liuyong.simplems.system.ent.Menu;

import java.util.List;

/**
 * 菜单Service接口
 *
 * @author liuyong
 * @date 2020/8/5 10:19
 */
public interface MenuService extends BaseService<Menu> {
    /**
     * 查看层级菜单
     *
     * @param
     * @return java.util.List<com.liuyong.simplems.system.ent.Menu>
     */
    List<Menu> listMenusByLevel();

    /**
     * 递归设置子菜单信息
     *
     * @param menu 父菜单
     * @param allMenus 所有菜单集合
     * @return void
     */
    void RecursiveChild(Menu menu, List<Menu> allMenus);

    /**
     * 通过用户账号返回用户拥有的菜单集
     *
     * @param account 用户账号
     * @return 菜单集
     */
    List<Menu> getMenusByAccount(String account);
}
