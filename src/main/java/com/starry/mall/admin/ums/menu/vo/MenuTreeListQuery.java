package com.starry.mall.admin.ums.menu.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/6/13 21:19
 */
@Data
@Accessors(chain = true)
public class MenuTreeListQuery implements Serializable {
    @ApiModelProperty("菜单名称")
    private String name;
    @ApiModelProperty("父菜单ID")
    private Long parentId;

}
