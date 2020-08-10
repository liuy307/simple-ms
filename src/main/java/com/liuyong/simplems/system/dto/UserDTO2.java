package com.liuyong.simplems.system.dto;

import com.liuyong.simplems.system.ent.Role;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 111
 *
 * @author liuyong
 * @date 2020/8/10 18:00
 */
@Data
public class UserDTO2 {
    @ApiModelProperty(value = "主键id", example = "1")
    private Integer id;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("账号")
    private String account;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("用户角色名字集合")
    private List<String> roleNameList;
}
