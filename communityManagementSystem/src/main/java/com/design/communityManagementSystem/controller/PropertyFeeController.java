package com.design.communityManagementSystem.controller;

import com.design.communityManagementSystem.pojo.PropertyFee;
import com.design.communityManagementSystem.service.PropertyFeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.design.communityManagementSystem.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.design.communityManagementSystem.dto.Page;
import java.io.IOException;
import java.util.Map;
/**
 * (PropertyFee)表控制层
 *
 * @author makejava
 */
@RestController
@RequestMapping("/propertyFee")
public class PropertyFeeController {
    /**
     * 服务对象
     */
    @Autowired
    private PropertyFeeService propertyFeeService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<PropertyFee>page) throws Exception{
        return this.propertyFeeService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<PropertyFee> queryById(@RequestBody PropertyFee propertyFee) {
        return this.propertyFeeService.queryById(propertyFee.getId());
    }

    /**
     * 新增数据
     *
     * @param propertyFee 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody PropertyFee propertyFee) {
        return this.propertyFeeService.insert(propertyFee);
    }

    /**
     * 编辑数据
     *
     * @param propertyFee 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody PropertyFee propertyFee) {
        return this.propertyFeeService.update(propertyFee);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody PropertyFee propertyFee) {
        return this.propertyFeeService.deleteById(propertyFee.getId());
    }

}

