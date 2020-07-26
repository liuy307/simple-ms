package com.liuyong.simplems.system.api;

import com.liuyong.simplems.common.base.ExceptionHandlerController;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@RestController
@RequestMapping("test")
//@Api(value="用户controller",tags={"用户操作接口"})
public class TestController extends ExceptionHandlerController {
    @ApiOperation(value="方法描述-测试", notes ="提示内容")
    @GetMapping("/hello")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value="用户id",required=true)})
    public String hello(@RequestParam(required = true) int id) {
        return "hello, spring boot! "+ id;
    }

    @ApiOperation(value="方法描述-测试2", notes ="提示内容2")
    @GetMapping("/hi")
    public String hi() throws FileNotFoundException {
        InputStream input = new FileInputStream("src/readme.txt");
        return "hi";
    }
}
