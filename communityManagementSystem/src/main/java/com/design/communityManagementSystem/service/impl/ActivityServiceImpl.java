package com.design.communityManagementSystem.service.impl;

import com.design.communityManagementSystem.dto.Page;
import com.design.communityManagementSystem.mapper.ActivityMapper;
import com.design.communityManagementSystem.mapper.SignUpMapper;
import com.design.communityManagementSystem.pojo.Activity;
import com.design.communityManagementSystem.pojo.SignUp;
import com.design.communityManagementSystem.pojo.res.RestFulBean;
import com.design.communityManagementSystem.service.ActivityService;
import com.design.communityManagementSystem.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * (Activity)表服务实现类
 *
 * @author makejava
 */
@Service("activityService")
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityMapper activityMapper;
    @Autowired
    private SignUpMapper signUpMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getList(Page<Activity> page) throws Exception{
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum =page.getPageNum();
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Activity> list= activityMapper.getPageListByCondition(page);
        if(list.size()>0){  //如果数据大于0 用for循环把照片的完整路劲返回前端显示
            for(Activity activity: list){
                activity.setImagesUrl("http://localhost:8087/file/"+activity.getImages()); //照片
                activity.setVideosUrl("http://localhost:8087/file/"+activity.getVideos()); //视频
                List<SignUp> signUpList= signUpMapper.getListByActivityId(activity.getId()); //根据活动主题获取报名人数
                if(signUpList.size()==0){  //如果没人报名 那么报名人数默认为0
                    activity.setSignedNum(0);
                }
                else {  //报名的人数
                    activity.setSignedNum(signUpList.size());
                }
            }
        }
        //根据条件查询数据的条数
        Integer count = activityMapper.getPageListCount(page);
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
    public RestFulBean<Activity> queryById(Integer id) {
       Activity activity=this.activityMapper.queryById(id);
        activity.setImagesUrl("http://localhost:8087/file/"+activity.getImages()); //照片
        activity.setVideosUrl("http://localhost:8087/file/"+activity.getVideos()); //视频
         return RestFulBean.succ(activity);
    }

    /**
     * 新增数据
     *
     * @param activity 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Activity activity) {
        this.activityMapper.insert(activity);//执行数据库的新增语句
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param activity 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Activity activity) {
        this.activityMapper.update(activity);//执行数据库的修改语句 根据id 修改
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
        this.activityMapper.deleteById(id);//执行数据库的删除语句 根据id 删除
         return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<List<Activity>> getActivityList() {
        List<Activity> list =activityMapper.getActivityList();
        return RestFulBean.succ(list);
    }
}
