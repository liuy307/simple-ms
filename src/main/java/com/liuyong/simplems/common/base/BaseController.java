package com.liuyong.simplems.common.base;

import com.liuyong.simplems.common.core.model.ApiResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class BaseController<E> extends ExceptionHandlerController{
    @Autowired
    protected BaseService<E> baseService;

    @ApiOperation("Base查询全部")
    @GetMapping("/list")
    public ApiResponse<List<E>> list() {
        return ApiResponse.success(baseService.list()) ;
    }

    @ApiOperation("Base按id查询")
    @GetMapping("/getTById")
    public ApiResponse<E> getById(int id) {
        return ApiResponse.success(baseService.getById(id));
    }

    @ApiOperation("Base新增")
    @PostMapping("/save")
    public ApiResponse<Integer> save(E ent) {
        int i = baseService.save(ent);
        return ApiResponse.success(i);
    }

    @ApiOperation("Base修改")
    @PostMapping("/update")
    public ApiResponse<Integer> updateT(E ent) {
        return ApiResponse.success(baseService.update(ent));
    }

    @ApiOperation("Base删除")
    @GetMapping("/remove")
    public ApiResponse<Integer> remove(int id) {
        return ApiResponse.success(baseService.remove(id));
    }
}
