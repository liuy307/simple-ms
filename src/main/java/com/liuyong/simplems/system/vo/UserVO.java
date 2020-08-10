package com.liuyong.simplems.system.vo;

import com.liuyong.simplems.system.ent.Role;
import com.liuyong.simplems.system.ent.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 用户VO实体类
 *
 * @author liuyong
 * @date 2020/8/10 11:17
 */

@Data
public class UserVO extends User{
    @ApiModelProperty("用户角色集合")
    private List<Role> roleList;
}
