package com.design.communityManagementSystem.controller;

import com.design.communityManagementSystem.pojo.SignUp;
import com.design.communityManagementSystem.service.SignUpService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.design.communityManagementSystem.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.design.communityManagementSystem.dto.Page;
import java.io.IOException;
import java.util.Map;
/**
 * (SignUp)表控制层
 *
 * @author makejava
 */
@RestController
@RequestMapping("/signUp")
public class SignUpController {
    /**
     * 服务对象
     */
    @Autowired
    private SignUpService signUpService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<SignUp>page) throws Exception{
        return this.signUpService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<SignUp> queryById(@RequestBody SignUp signUp) {
        return this.signUpService.queryById(signUp.getId());
    }

    /**
     * 新增数据
     *
     * @param signUp 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody SignUp signUp) {
        return this.signUpService.insert(signUp);
    }

    /**
     * 编辑数据
     *
     * @param signUp 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody SignUp signUp) {
        return this.signUpService.update(signUp);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody SignUp signUp) {
        return this.signUpService.deleteById(signUp.getId());
    }

}

