package com.design.communityManagementSystem.service.impl;

import com.design.communityManagementSystem.mapper.ManagerMapper;
import com.design.communityManagementSystem.mapper.UsersMapper;
import com.design.communityManagementSystem.pojo.Manager;
import com.design.communityManagementSystem.pojo.Users;
import com.design.communityManagementSystem.pojo.res.RestFulBean;
import com.design.communityManagementSystem.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Map;

@Service("LoginService")
public class  LoginServiceImpl implements LoginService {
    @Autowired
    private ManagerMapper managerMapper;
    @Autowired
    private UsersMapper usersMapper;
    @Override
    public RestFulBean<Users> login(Users users) throws Exception {
        if(users.getUserNo()==null)
        {
            return RestFulBean.error("编号不能为空");
        }
        if(users.getPassword()==null)
        {
            return RestFulBean.error("密码不能为空");
        }
        if(users.getRole()==null)
        {
            return RestFulBean.error("角色不能为空");
        }
        Users user =new Users(); //new一个用户对象
        user.setRole(users.getRole());
        if(users.getRole().equals("用户")) //判断角色是否等于用户
        {

            Users usered =usersMapper.getByUserNo(users.getUserNo());//根据编号获取用户数据
            if(usered==null){
                return RestFulBean.error("该用户不存在");
            }
            //赋值
            user.setId(usered.getId());
            user.setUserName(usered.getUserName());
            user.setUserNo(usered.getUserNo());
            user.setTelephone(usered.getTelephone());
            user.setPassword(usered.getPassword());
        }

        if(users.getRole().equals("管理员")) //判断角色是否等于管理员
        {
            Manager manager =managerMapper.getByUserNo(users.getUserNo());//根据编号获取管理员数据
            if(manager==null){
                return RestFulBean.error("该管理员用户不存在");
            }
            //赋值
            user.setId(manager.getId());
            user.setUserName(manager.getUserName());
            user.setPassword(manager.getPassword());
        }
        //判断密码跟数据库是否一样
        if(users.getPassword().equals(user.getPassword())){
            return RestFulBean.succ(user); //如果密码一样将用户对象放回到前端
        }
        else{
            return RestFulBean.error("密码错误");
        }
    }
}
