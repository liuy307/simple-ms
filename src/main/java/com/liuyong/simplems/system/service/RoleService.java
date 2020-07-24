package com.liuyong.simplems.system.service;

import com.liuyong.simplems.common.base.BaseService;
import com.liuyong.simplems.system.ent.Role;

import java.util.List;

public interface RoleService extends BaseService<Role> {
    List<Integer> getIdByNameBatch(List<String> roleNameList);
}
