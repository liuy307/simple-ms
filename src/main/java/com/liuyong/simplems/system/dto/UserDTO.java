package com.liuyong.simplems.system.dto;

import com.liuyong.simplems.system.ent.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 用户DTO类
 *
 * @author liuyong
 * @date 2020/8/10 13:31
 */
@Data
public class UserDTO extends User {
    @ApiModelProperty("用户分配角色名字集合")
    private List<String> roleNameList;
}
