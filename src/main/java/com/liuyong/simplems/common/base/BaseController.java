package com.liuyong.simplems.common.base;

import com.liuyong.simplems.common.core.model.ApiResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * 基础Controller类，继承了全局异常捕捉Controller类
 *
 * @author liuyong
 * @date 2020/8/5 10:13
 */
public class BaseController<E> extends ExceptionHandlerController{
    @Autowired
    protected BaseService<E> baseService;

    /**
     * 基础Controller方法-查看
     *
     * @param
     * @return 表中所有记录
     */
    @ApiOperation("Base查询全部")
    @GetMapping("/list")
    public ApiResponse<List<E>> list() {
        return ApiResponse.success(baseService.list()) ;
    }

    /**
     * 基础Controller方法-查看（通过主键id）
     *
     * @param id 主键id
     * @return 表中对应id的单条记录
     */
    @ApiOperation("Base按id查询")
    @GetMapping("/getTById")
    public ApiResponse<E> getById(int id) {
        return ApiResponse.success(baseService.getById(id));
    }

    /**
     * 基础Controller方法-创建
     *
     * @param ent 实体类对象
     * @return 受影响的记录条数
     */
    @ApiOperation("Base新增")
    @PostMapping("/save")
    public ApiResponse<Integer> save(E ent) {
        int i = baseService.save(ent);
        return ApiResponse.success(i);
    }

    /**
     * 基础Controller方法-修改
     *
     * @param ent 实体类对象
     * @return 受影响的记录条数
     */
    @ApiOperation("Base修改")
    @PostMapping("/update")
    public ApiResponse<Integer> update(E ent) {
        return ApiResponse.success(baseService.update(ent));
    }

    /**
     * 基础Controller方法-删除
     *
     * @param id 主键id
     * @return 受影响的记录条数
     */
    @ApiOperation("Base删除")
    @GetMapping("/remove")
    public ApiResponse<Integer> remove(int id) {
        return ApiResponse.success(baseService.remove(id));
    }
}
