package com.design.communityManagementSystem.service;

import com.design.communityManagementSystem.pojo.PropertyFee;
import com.design.communityManagementSystem.pojo.res.RestFulBean;
import com.design.communityManagementSystem.dto.Page;
import java.io.IOException;
import java.util.Map;
/**
 * (PropertyFee)表服务接口
 *
 * @author makejava
 */
public interface PropertyFeeService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getList(Page<PropertyFee> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<PropertyFee> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param propertyFee 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(PropertyFee propertyFee);

    /**
     * 修改数据
     *
     * @param propertyFee 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(PropertyFee propertyFee);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

}
