package com.design.communityManagementSystem.mapper;

import com.design.communityManagementSystem.dto.Page;
import com.design.communityManagementSystem.pojo.Activity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Activity)表数据库访问层
 *
 * @author makejava
 */
public interface ActivityMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Activity queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<Activity> getPageListByCondition(@Param("page") Page<Activity> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<Activity> page);


    /**
     * 新增数据
     *
     * @param activity 实例对象
     * @return 影响行数
     */
    int insert(Activity activity);




    /**
     * 修改数据
     *
     * @param activity 实例对象
     * @return 影响行数
     */
    int update(Activity activity);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Activity> getIndexActivityList();

    Activity getIndexActivity();

    List<Activity> getActivityList();
}

