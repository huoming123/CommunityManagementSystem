package com.design.communityManagementSystem.mapper;

import com.design.communityManagementSystem.pojo.Payment;
import java.util.List;
import com.design.communityManagementSystem.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (Payment)表数据库访问层
 *
 * @author makejava
 */
public interface PaymentMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Payment queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<Payment> getPageListByCondition(@Param("page") Page<Payment> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<Payment> page);


    /**
     * 新增数据
     *
     * @param payment 实例对象
     * @return 影响行数
     */
    int insert(Payment payment);




    /**
     * 修改数据
     *
     * @param payment 实例对象
     * @return 影响行数
     */
    int update(Payment payment);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Payment> queryByYearAndMonth(String month, Integer year);
}

