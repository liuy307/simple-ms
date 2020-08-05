package com.liuyong.simplems.common.base;

import java.util.List;

/**
 * 基础Service接口
 *
 * @author liuyong
 * @date 2020/8/5 9:37
 */
public interface BaseService<E> {
    /**
     * 基础Service接口方法-查看
     *
     * @param
     * @return 表中所有记录
     */
    List<E> list();

    /**
     * 基础Service接口方法-查看（通过主键id）
     *
     * @param
     * @return 表中对应id的单条记录
     */
    E getById(int id);

    /**
     * 基础Service接口方法-创建
     *
     * @param ent 实体类对象
     * @return 受影响的记录条数
     */
    int save(E ent);

    /**
     * 基础Service接口方法-修改
     *
     * @param ent 实体类对象
     * @return 受影响的记录条数
     */
    int update(E ent);

    /**
     * 基础Service接口方法-删除
     *
     * @param id 主键id
     * @return 受影响的记录条数
     */
    int remove(int id);
}
