package com.design.communityManagementSystem.service.impl;

import com.design.communityManagementSystem.pojo.SignUp;
import com.design.communityManagementSystem.mapper.SignUpMapper;
import com.design.communityManagementSystem.service.SignUpService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.design.communityManagementSystem.pojo.res.RestFulBean;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.design.communityManagementSystem.util.PageUtil;
import com.design.communityManagementSystem.dto.Page;
/**
 * (SignUp)表服务实现类
 *
 * @author makejava
 */
@Service("signUpService")
public class SignUpServiceImpl implements SignUpService {
    @Autowired
    private SignUpMapper signUpMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getList(Page<SignUp> page) throws Exception{
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum =page.getPageNum();
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<SignUp> list= signUpMapper.getPageListByCondition(page);
        if(list.size()>0){  //如果数据大于0 用for循环把照片的完整路劲返回前端显示
            for(SignUp signUp: list){
               
            }
        }
        //根据条件查询数据的条数
        Integer count = signUpMapper.getPageListCount(page);
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
    public RestFulBean<SignUp> queryById(Integer id) {
       SignUp signUp=this.signUpMapper.queryById(id);
         return RestFulBean.succ(signUp);
    }

    /**
     * 新增数据
     *
     * @param signUp 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(SignUp signUp) {
        if(signUp.getTelephone()==null){
            return RestFulBean.error("手机号码不能为空");
        }
        if(signUp.getTelephone().trim().length()!=11){
            return RestFulBean.error("请输入11位手机号码");
        }
        //手机号码只能是数字 用正则法则判断
        Pattern pattern = Pattern.compile("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
        Matcher isNum = pattern.matcher(signUp.getTelephone().trim());
        if(!isNum.matches()){  //如果不等于true 则进去条件
            return RestFulBean.error("手机号码只能是数字"); //不是数字
        }
        SignUp signUped =signUpMapper.queryByUserNoAndActiveId(signUp.getActivityId(),signUp.getUserNo()); //根据活动id跟当前学生判断是否已经报名了
        if(signUped!=null){
            return RestFulBean.error("你已经报名，请不要重复报名");
        }

        this.signUpMapper.insert(signUp);//执行数据库的新增语句
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param signUp 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(SignUp signUp) {
        this.signUpMapper.update(signUp);//执行数据库的修改语句 根据id 修改
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
        this.signUpMapper.deleteById(id);//执行数据库的删除语句 根据id 删除
         return RestFulBean.succ("删除成功");
    }
}
