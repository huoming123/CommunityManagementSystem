package com.design.communityManagementSystem.controller;

import com.design.communityManagementSystem.dto.Page;
import com.design.communityManagementSystem.pojo.Activity;
import com.design.communityManagementSystem.pojo.res.RestFulBean;
import com.design.communityManagementSystem.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * (Activity)表控制层
 *
 * @author makejava
 */
@RestController
@RequestMapping("/activity")
public class ActivityController {
    /**
     * 服务对象
     */
    @Autowired
    private ActivityService activityService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<Activity>page) throws Exception{
        return this.activityService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<Activity> queryById(@RequestBody Activity activity) {
        return this.activityService.queryById(activity.getId());
    }

    /**
     * 新增数据
     *
     * @param activity 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Activity activity) {
        return this.activityService.insert(activity);
    }

    /**
     * 编辑数据
     *
     * @param activity 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Activity activity) {
        return this.activityService.update(activity);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Activity activity) {
        return this.activityService.deleteById(activity.getId());
    }
    @PostMapping("/get/activity/list")
    public RestFulBean<List<Activity>> getActivityList() throws Exception{
        return this.activityService.getActivityList();
    }
}

