package com.design.communityManagementSystem.service.impl;

import com.design.communityManagementSystem.pojo.Users;
import com.design.communityManagementSystem.mapper.UsersMapper;
import com.design.communityManagementSystem.service.UsersService;
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
 * (Users)表服务实现类
 *
 * @author makejava
 */
@Service("usersService")
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getList(Page<Users> page) throws Exception{
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum =page.getPageNum();
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Users> list= usersMapper.getPageListByCondition(page);
        //根据条件查询数据的条数
        Integer count = usersMapper.getPageListCount(page);
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
    public RestFulBean<Users> queryById(Integer id) {
       Users users=this.usersMapper.queryById(id);
         return RestFulBean.succ(users);
    }

    /**
     * 新增数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Users users) {
        if(users.getUserName()==null){//对前端传过来的值进行判空处理，如果为空，就返回对应的报错信息
            return RestFulBean.error("姓名不能为空");
        }

        if(users.getTelephone()==null)
        {
            return RestFulBean.error("手机号码不能为空");
        }
        if(users.getArea()== null)
        {
            return RestFulBean.error("面积不能为空");
        }
        if(users.getCardId()==null)
        {
            return RestFulBean.error("身份证不能为空");
        }
        if(users.getCardId().length()!=18)
        {
            return RestFulBean.error("请输入18位身份证");
        }
        if(users.getTelephone().trim().length()!=11){
            return RestFulBean.error("请输入11位手机号码");
        }
        //手机号码只能是数字 用正则法则判断
        Pattern pattern = Pattern.compile("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
        Matcher isNum = pattern.matcher(users.getTelephone().trim());
        if(!isNum.matches()){  //如果不等于true 则进去条件
            return RestFulBean.error("手机号码只能是数字"); //不是数字
        }
        //13位时间戳 不可能重复
        long timeMillis=System.currentTimeMillis(); //当前系统时间戳

        String userNo=String.valueOf(timeMillis).substring(0,13);
        users.setUserNo(String.valueOf(userNo));
        users.setPassword("123456"); //默认密码
        this.usersMapper.insert(users);//执行数据库的新增语句
        return RestFulBean.succ("录入成功,该居民编号为"+users.getUserNo()+"密码默认为123456");
    }

    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Users users) {
        this.usersMapper.update(users);//执行数据库的修改语句 根据id 修改
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
        this.usersMapper.deleteById(id);//执行数据库的删除语句 根据id 删除
         return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<List<Users>> getUserList() {
        List<Users> list =usersMapper.getUserList();
        return RestFulBean.succ(list);
    }
}
