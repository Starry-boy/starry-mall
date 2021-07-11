package com.starry.mall.admin.ums.menu.service;

import com.starry.mall.admin.ums.menu.po.UmsMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.starry.mall.admin.ums.menu.vo.MenuNodeVO;
import com.starry.mall.admin.ums.menu.vo.MenuTreeListQuery;
import com.starry.mall.commons.IBaseService;

import java.util.List;

public interface UmsMenuService extends IBaseService<UmsMenu> {

    /**
     * 树结构获取菜单列表
     * @param query
     * @return
     */
    List<MenuNodeVO> treeList(MenuTreeListQuery query);
}
