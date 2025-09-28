package com.design.communityManagementSystem.mapper;

import com.design.communityManagementSystem.pojo.SignUp;
import java.util.List;
import com.design.communityManagementSystem.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (SignUp)表数据库访问层
 *
 * @author makejava
 */
public interface SignUpMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SignUp queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<SignUp> getPageListByCondition(@Param("page") Page<SignUp> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<SignUp> page);


    /**
     * 新增数据
     *
     * @param signUp 实例对象
     * @return 影响行数
     */
    int insert(SignUp signUp);




    /**
     * 修改数据
     *
     * @param signUp 实例对象
     * @return 影响行数
     */
    int update(SignUp signUp);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<SignUp> getListByActivityId(Integer id);

    SignUp queryByUserNoAndActiveId(Integer activityId, String userNo);
}

