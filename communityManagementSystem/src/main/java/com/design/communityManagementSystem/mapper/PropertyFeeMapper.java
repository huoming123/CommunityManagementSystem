package com.design.communityManagementSystem.mapper;

import com.design.communityManagementSystem.pojo.PropertyFee;
import java.util.List;
import com.design.communityManagementSystem.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (PropertyFee)表数据库访问层
 *
 * @author makejava
 */
public interface PropertyFeeMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PropertyFee queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<PropertyFee> getPageListByCondition(@Param("page") Page<PropertyFee> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<PropertyFee> page);


    /**
     * 新增数据
     *
     * @param propertyFee 实例对象
     * @return 影响行数
     */
    int insert(PropertyFee propertyFee);




    /**
     * 修改数据
     *
     * @param propertyFee 实例对象
     * @return 影响行数
     */
    int update(PropertyFee propertyFee);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

