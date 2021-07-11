package com.starry.mall.admin.ums.menu.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/6/13 19:26
 */
@Data
public class UpdateMenuCommand implements Serializable {
    @ApiModelProperty(value = "")
    private Long id;

    /**
     * 父级ID
     */

    @ApiModelProperty(value = "父级ID")
    private Long parentId;

    /**
     * 菜单名称
     */

    @ApiModelProperty(value = "菜单名称")
    private String title;

    /**
     * 菜单级数
     */

    @ApiModelProperty(value = "菜单级数")
    private Integer level;

    /**
     * 菜单排序
     */

    @ApiModelProperty(value = "菜单排序")
    private Integer sort;

    /**
     * 前端名称
     */

    @ApiModelProperty(value = "前端名称")
    private String name;

    /**
     * 前端图标
     */

    @ApiModelProperty(value = "前端图标")
    private String icon;

    /**
     * 前端隐藏
     */

    @ApiModelProperty(value = "前端隐藏")
    private Integer hidden;

}
