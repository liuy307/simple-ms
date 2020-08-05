package com.liuyong.simplems.system.dao;

import com.liuyong.simplems.common.base.BaseMapper;
import com.liuyong.simplems.system.ent.Menu;
import com.liuyong.simplems.system.ent.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Set;

@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {
    List<Integer> getIdByNameBatch(List<String> permissionNameList);

    Set<String> getPermissionNameSetByAccount(String account);
}
