package com.design.communityManagementSystem.service;

import com.design.communityManagementSystem.dto.Page;
import com.design.communityManagementSystem.pojo.Message;
import com.design.communityManagementSystem.pojo.res.RestFulBean;

import java.util.Map;

/**
 * (Message)表服务接口
 *
 * @author makejava
 * @since  19:23:04
 */
public interface MessageService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getList(Page<Message> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Message> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param message 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Message message);

    /**
     * 修改数据
     *
     * @param message 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Message message);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

}
