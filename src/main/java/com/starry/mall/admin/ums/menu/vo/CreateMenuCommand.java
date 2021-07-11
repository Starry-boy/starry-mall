package com.starry.mall.admin.ums.menu.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/6/13 17:49
 */
@Data
public class CreateMenuCommand implements Serializable {
    /**
     * 父级ID
     */
    @TableField(value = "parent_id")
    @ApiModelProperty(value="父级ID")
    private Long parentId;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
     * 菜单名称
     */
    @TableField(value = "title")
    @ApiModelProperty(value="菜单名称")
    private String title;

    /**
     * 菜单级数
     */
    @TableField(value = "level")
    @ApiModelProperty(value="菜单级数")
    private Integer level;

    /**
     * 菜单排序
     */
    @TableField(value = "sort")
    @ApiModelProperty(value="菜单排序")
    private Integer sort;

    /**
     * 前端名称
     */
    @TableField(value = "name")
    @ApiModelProperty(value="前端名称")
    private String name;

    /**
     * 前端图标
     */
    @TableField(value = "icon")
    @ApiModelProperty(value="前端图标")
    private String icon;

    /**
     * 前端隐藏
     */
    @TableField(value = "hidden")
    @ApiModelProperty(value="前端隐藏")
    private Integer hidden;
}
