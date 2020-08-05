package com.liuyong.simplems.common.base;

import java.util.List;

/**
 * 基础Mapper接口
 *
 * @author liuyong
 * @date 2020/8/5 9:35
 */
public interface BaseMapper<E> {
    /**
     * 基础Mapper接口-查看
     *
     * @param
     * @return 表中所有记录
     */
    List<E> list();

    /**
     * 基础Mapper接口-查看（通过主键id）
     *
     * @param
     * @return 表中对应id的单条记录
     */
    E getById(int id);

    /**
     * 基础Mapper接口-创建
     *
     * @param ent 实体类对象
     * @return 受影响的记录条数
     */
    int save(E ent);

    /**
     * 基础Mapper接口-修改
     *
     * @param ent 实体类对象
     * @return 受影响的记录条数
     */
    int update(E ent);

    /**
     * 基础Mapper接口-删除
     *
     * @param id 主键id
     * @return 受影响的记录条数
     */
    int remove(int id);
}
