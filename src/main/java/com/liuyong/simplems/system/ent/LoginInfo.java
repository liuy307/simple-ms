package com.liuyong.simplems.system.ent;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("用户登录信息")
public class LoginInfo  implements Serializable {
    @ApiModelProperty("账号")
    private String accountNumber;

    @ApiModelProperty("密码")
    private String password;
//
//    @ApiModelProperty("jwt令牌")
//    private String token;
}
