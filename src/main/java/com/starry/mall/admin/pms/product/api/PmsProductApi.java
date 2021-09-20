package com.starry.mall.admin.pms.product.api;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.starry.mall.admin.ums.menu.po.UmsMenu;
import com.starry.mall.commons.domain.WebResult;
import com.starry.mall.constant.HttpMethod;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/6/13 17:08
 */
@RestController
@RequestMapping("/pms/product")
@Api(tags = "PmsProductApi", value = "商品管理")
public class PmsProductApi {

    @GetMapping("/list")
    @ApiOperation(value = "商品列表", httpMethod = HttpMethod.GET)
    public WebResult<List<UmsMenu>> list(@PathVariable String parentId) {

        return WebResult.success(null);
    }


}
