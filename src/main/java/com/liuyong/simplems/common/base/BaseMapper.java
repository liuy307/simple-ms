package com.liuyong.simplems.common.base;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface BaseMapper<E> {
    List<E> list();

    E getById(int id);

    int save(E ent);

    int update(E ent);

    int remove(int id);
}
