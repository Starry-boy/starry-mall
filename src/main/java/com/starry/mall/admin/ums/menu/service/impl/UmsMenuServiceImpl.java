package com.starry.mall.admin.ums.menu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.starry.mall.admin.ums.menu.mapper.UmsMenuMapper;
import com.starry.mall.admin.ums.menu.po.UmsMenu;
import com.starry.mall.admin.ums.menu.service.UmsMenuService;
import com.starry.mall.admin.ums.menu.vo.MenuNodeVO;
import com.starry.mall.admin.ums.menu.vo.MenuTreeListQuery;
import com.starry.mall.utils.ConvertUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UmsMenuServiceImpl extends ServiceImpl<UmsMenuMapper, UmsMenu> implements UmsMenuService {

    @Override
    public Long insert(UmsMenu po) {
        return (long) baseMapper.insert(po);
    }

    @Override
    public List<MenuNodeVO> treeList(MenuTreeListQuery query) {
        List<UmsMenu> list = super.list();
        List<MenuNodeVO> nodeVOList = ConvertUtil.convert(list, MenuNodeVO::new);

        return nodeVOList.stream()
                .filter(m -> Long.valueOf(0L).equals(m.getParentId()))
                .map(m -> convertMenuNodeVO(m, nodeVOList))
                .collect(Collectors.toList());
    }

    private MenuNodeVO convertMenuNodeVO(MenuNodeVO node, List<MenuNodeVO> nodeVOList) {
        return node.setChildNodes(nodeVOList.stream()
                .filter(m -> node.getId().equals(m.getParentId()))
                .map(m -> convertMenuNodeVO(m,nodeVOList))
                .collect(Collectors.toList()));
    }
}
