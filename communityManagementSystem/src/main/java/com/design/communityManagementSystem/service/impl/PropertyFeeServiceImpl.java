package com.design.communityManagementSystem.service.impl;

import com.design.communityManagementSystem.pojo.PropertyFee;
import com.design.communityManagementSystem.mapper.PropertyFeeMapper;
import com.design.communityManagementSystem.service.PropertyFeeService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.design.communityManagementSystem.pojo.res.RestFulBean;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import com.design.communityManagementSystem.util.PageUtil;
import com.design.communityManagementSystem.dto.Page;
/**
 * (PropertyFee)表服务实现类
 *
 * @author makejava
 */
@Service("propertyFeeService")
public class PropertyFeeServiceImpl implements PropertyFeeService {
    @Autowired
    private PropertyFeeMapper propertyFeeMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getList(Page<PropertyFee> page) throws Exception{
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum =page.getPageNum();
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<PropertyFee> list= propertyFeeMapper.getPageListByCondition(page);
        if(list.size()>0){  //如果数据大于0 用for循环把照片的完整路劲返回前端显示
            for(PropertyFee propertyFee: list){
               
            }
        }
        //根据条件查询数据的条数
        Integer count = propertyFeeMapper.getPageListCount(page);
        //拿到总条数进行分页处理
        Map<Object, Object> map = PageUtil.pagingPrepare(page, count);
        //最后把查询到的数据用map返回前显示
        map.put("list",list);
        return RestFulBean.succ(map);
    }
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RestFulBean<PropertyFee> queryById(Integer id) {
       PropertyFee propertyFee=this.propertyFeeMapper.queryById(id);
         return RestFulBean.succ(propertyFee);
    }

    /**
     * 新增数据
     *
     * @param propertyFee 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(PropertyFee propertyFee) {
        if(propertyFee.getFee()==null){
            return RestFulBean.error("收费标准不能为空");
        }
        if(propertyFee.getYear()==null){
            return RestFulBean.error("年份不能为空");
        }
        if(propertyFee.getMonth()==null){
            return RestFulBean.error("月份不能为空");
        }
        this.propertyFeeMapper.insert(propertyFee);//执行数据库的新增语句
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param propertyFee 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(PropertyFee propertyFee) {
        this.propertyFeeMapper.update(propertyFee);//执行数据库的修改语句 根据id 修改
        return RestFulBean.succ("修改成功"); 
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public RestFulBean<String> deleteById(Integer id) {
        this.propertyFeeMapper.deleteById(id);//执行数据库的删除语句 根据id 删除
         return RestFulBean.succ("删除成功");
    }
}
