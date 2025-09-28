package com.design.communityManagementSystem.service;

import com.design.communityManagementSystem.pojo.SignUp;
import com.design.communityManagementSystem.pojo.res.RestFulBean;
import com.design.communityManagementSystem.dto.Page;
import java.io.IOException;
import java.util.Map;
/**
 * (SignUp)表服务接口
 *
 * @author makejava
 */
public interface SignUpService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getList(Page<SignUp> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<SignUp> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param signUp 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(SignUp signUp);

    /**
     * 修改数据
     *
     * @param signUp 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(SignUp signUp);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

}
