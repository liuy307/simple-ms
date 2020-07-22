package com.liuyong.simplems.system.api;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("test")
@Api(value="用户controller",tags={"用户操作接口"})
public class TestController {
    @ApiOperation(value="方法描述-测试", notes ="提示内容")
    @GetMapping("/hello")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value="用户id",required=true)})
    public String hello(@RequestParam(required = true) String id) {
        return "hello, spring boot! "+ id;
    }
}
