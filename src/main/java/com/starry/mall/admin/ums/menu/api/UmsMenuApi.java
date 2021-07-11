package com.starry.mall.admin.ums.menu.api;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.starry.mall.admin.ums.menu.po.UmsMenu;
import com.starry.mall.admin.ums.menu.service.UmsMenuService;
import com.starry.mall.admin.ums.menu.vo.*;
import com.starry.mall.commons.api.CommonResultCode;
import com.starry.mall.commons.domain.WebResult;
import com.starry.mall.constant.HttpMethod;
import com.starry.mall.utils.ConvertUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author ratel
 * @version 1.0
 * @description: 后台菜单管理
 * @DATE 2021/6/13 17:37
 */
@RestController
@RequestMapping("/menu")
@Api(tags = "UmsMenuApi", value = "后台菜单管理")
public class UmsMenuApi {

    @Autowired
    private UmsMenuService umsMenuService;

    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID获取菜单详情", notes = "根据ID获取菜单详情", httpMethod = HttpMethod.GET)
    public WebResult<UmsMenuVO> getItem(@PathVariable("id")
                                        @Valid
                                        @NotEmpty(message = "通过菜单ID查询菜单失败，请检查礼品编码是否正确") String id) {
        UmsMenu umsMenu = umsMenuService.getById(Long.valueOf(id));
        return WebResult.success(ConvertUtil.convert(umsMenu, UmsMenuVO::new));
    }

    @GetMapping("/list/{parentId}")
    @ApiOperation(value = "根据父菜单ID获取菜单列表", httpMethod = HttpMethod.GET)
    public WebResult<List<UmsMenu>> list(@PathVariable String parentId) {
        List<UmsMenu> list = umsMenuService.list(new LambdaQueryWrapper<UmsMenu>().eq(UmsMenu::getParentId, Long.valueOf(parentId)));
        return WebResult.success(list);
    }


    @GetMapping("/treeList")
    @ApiOperation(value = "树形结构返回所有菜单", httpMethod = HttpMethod.GET)
    @ApiImplicitParam(name = "name",value = "菜单名称", defaultValue = "商品")
    public WebResult<List<MenuNodeVO>> treeList(@RequestParam(required = false) String name) {
        List<MenuNodeVO> list = umsMenuService.treeList(new MenuTreeListQuery().setName(name));
        return WebResult.success(list);
    }

    @PostMapping("/create")
    @ApiOperation(value = "创建菜单", notes = "创建菜单1", httpMethod = HttpMethod.POST)
    public WebResult<Long> create(@Valid @RequestBody CreateMenuCommand command) {
        Long id = umsMenuService.insert(ConvertUtil.convert(command, UmsMenu::new));
        return id == null ? WebResult.failed(CommonResultCode.UMS_MENU_INSERT_FAILED) : WebResult.success(id);
    }

    @PostMapping("/update/{id}")
    @ApiOperation(value = "修改菜单", notes = "根据ID获取菜单详情", httpMethod = HttpMethod.POST)
    public WebResult<Boolean> update(@RequestBody @Valid
                                     @PathVariable("id") @NotEmpty(message = "更新菜单失败，ID不能为空") String id,
                                     UpdateMenuCommand command) {

        UmsMenu umsMenu = ConvertUtil.convert(command, UmsMenu::new).setId(Long.valueOf(id));
        boolean isSuccess = umsMenuService.updateById(umsMenu);
        return isSuccess ? WebResult.success(true) : WebResult.failed(CommonResultCode.UMS_MENU_UPDATE_FAILED);
    }

    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除菜单", notes = "根据ID删除菜单", httpMethod = HttpMethod.POST)
    public WebResult<Boolean> delete(@PathVariable("id") @NotEmpty(message = "删除菜单失败，ID不能为空") String id) {
        boolean isSuccess = umsMenuService.removeById(id);
        return isSuccess ? WebResult.success(true) : WebResult.failed(CommonResultCode.UMS_MENU_DELETE_FAILED);
    }

    @PostMapping("/batchDelete")
    @ApiOperation(value = "批量删除菜单", notes = "根据ID批量删除菜单", httpMethod = HttpMethod.POST)
    @ApiImplicitParam(name = "ids", value = "菜单ID数组", required = true)
    public WebResult<Boolean> delete(@RequestBody @NotEmpty(message = "批量删除菜单失败，ID不能为空") List<String> ids) {
        boolean isSuccess = umsMenuService.removeByIds(ids);
        return isSuccess ? WebResult.success(true) : WebResult.failed(CommonResultCode.UMS_MENU_DELETE_FAILED);
    }
}
