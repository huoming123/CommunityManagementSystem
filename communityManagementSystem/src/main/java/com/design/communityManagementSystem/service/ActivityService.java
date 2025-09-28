package com.design.communityManagementSystem.service;

import com.design.communityManagementSystem.dto.Page;
import com.design.communityManagementSystem.pojo.Activity;
import com.design.communityManagementSystem.pojo.res.RestFulBean;

import java.util.List;
import java.util.Map;

/**
 * (Activity)表服务接口
 *
 * @author makejava
 */
public interface ActivityService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getList(Page<Activity> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Activity> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param activity 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Activity activity);

    /**
     * 修改数据
     *
     * @param activity 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Activity activity);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<List<Activity>> getActivityList();
}
