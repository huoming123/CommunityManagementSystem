package com.design.communityManagementSystem.service;

import com.design.communityManagementSystem.pojo.Users;
import com.design.communityManagementSystem.pojo.res.RestFulBean;

import java.util.Map;

public interface LoginService {

    RestFulBean<Users> login(Users users) throws Exception;
}
