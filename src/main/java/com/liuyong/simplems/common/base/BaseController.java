package com.liuyong.simplems.common.base;

import com.alibaba.fastjson.JSON;
import com.liuyong.simplems.common.core.model.ApiResponse;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class BaseController<E> extends ExceptionHandlerController{
    @Autowired
    protected BaseService<E> baseService;

    @ApiOperation("查询全部")
    @GetMapping("/list")
    public ApiResponse<List<E>> list() {
        return ApiResponse.success(baseService.list()) ;
    }

    @ApiOperation("按id查询")
    @GetMapping("/getTById")
    public ApiResponse<E> getById(int id) {
        return ApiResponse.success(baseService.getById(id));
    }

    @ApiOperation("增加")
    @PostMapping("/save")
    public ApiResponse<Integer> save(E ent) {
        int i = baseService.save(ent);
        return ApiResponse.success(i);
    }

    @ApiOperation("修改")
    @PostMapping("/update")
    public ApiResponse<Integer> updateT(E ent) {
        return ApiResponse.success(baseService.update(ent));
    }

    @ApiOperation("删除")
    @GetMapping("/remove")
    public ApiResponse<Integer> remove(int id) {
        return ApiResponse.success(baseService.remove(id));
    }
}
