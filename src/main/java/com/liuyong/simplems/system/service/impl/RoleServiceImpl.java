package com.liuyong.simplems.system.service.impl;

import com.liuyong.simplems.common.base.BaseService;
import com.liuyong.simplems.common.base.BaseServiceImpl;
import com.liuyong.simplems.system.dao.RoleMapper;
import com.liuyong.simplems.system.ent.Role;
import com.liuyong.simplems.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {
    @Autowired
    RoleMapper roleMapper;

    // 根据角色roleNameList获取idList
    @Override
    public List<Integer> getIdByNameBatch(List<String> roleNameList) {
        return roleMapper.getIdByNameBatch(roleNameList);
    }
}
