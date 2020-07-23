package com.liuyong.simplems.common.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class BaseServiceImpl<E> implements BaseService<E> {
    @Autowired
    BaseMapper<E> baseMapper;

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
