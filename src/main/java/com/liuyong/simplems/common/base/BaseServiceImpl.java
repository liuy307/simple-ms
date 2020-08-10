package com.liuyong.simplems.common.base;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 基础Service接口实现类
 *
 * @author liuyong
 * @date 2020/8/5 9:43
 */
public class BaseServiceImpl<E> implements BaseService<E> {
    @Autowired
    protected BaseMapper<E> baseMapper;

    @Override
    public List<E> list() {
        return baseMapper.list();
    }

    @Override
    public E getById(int id) {
        return baseMapper.getById(id);
    }

    @Override
    public int save(E ent) {
        return baseMapper.save(ent);
    }

    @Override
    public int update(E ent) {
        return baseMapper.update(ent);
    }

    @Override
    public int remove(int id) {
        return baseMapper.remove(id);
    }
}
