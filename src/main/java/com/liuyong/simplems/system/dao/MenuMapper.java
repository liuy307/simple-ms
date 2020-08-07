package com.liuyong.simplems.system.dao;

import com.liuyong.simplems.common.base.BaseMapper;
import com.liuyong.simplems.system.ent.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Set;

@Mapper
public interface MenuMapper extends BaseMapper<Menu> {
    List<Integer> getIdByNameBatch(List<String> menuNameList);

    List<Menu> getMenusByAccount(String account);
}
