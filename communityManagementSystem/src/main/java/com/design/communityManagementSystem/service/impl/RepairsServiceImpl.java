package com.design.communityManagementSystem.service.impl;

import com.design.communityManagementSystem.pojo.Repairs;
import com.design.communityManagementSystem.mapper.RepairsMapper;
import com.design.communityManagementSystem.service.RepairsService;
import com.design.communityManagementSystem.util.FileUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.design.communityManagementSystem.pojo.res.RestFulBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import com.design.communityManagementSystem.util.PageUtil;
import com.design.communityManagementSystem.dto.Page;
import org.springframework.web.multipart.MultipartFile;

/**
 * (Repairs)表服务实现类
 *
 * @author makejava
 */
@Service("repairsService")
public class RepairsServiceImpl implements RepairsService {
    @Autowired
    private RepairsMapper repairsMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getList(Page<Repairs> page) throws Exception{
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum =page.getPageNum();
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Repairs> list= repairsMapper.getPageListByCondition(page);
        if(list.size()>0){  //如果数据大于0 用for循环把照片的完整路劲返回前端显示
            for(Repairs repairs: list){
                if(repairs.getStatus().equals("待修中")){ //修改之后 删除按钮不可编辑
                    repairs.setDisabled(false);
                }
                else{
                    repairs.setDisabled(true);
                }
            }
        }
        //根据条件查询数据的条数
        Integer count = repairsMapper.getPageListCount(page);
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
    public RestFulBean<Repairs> queryById(Integer id) {
       Repairs repairs=this.repairsMapper.queryById(id);
         return RestFulBean.succ(repairs);
    }

    /**
     * 新增数据
     *
     * @param repairs 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Repairs repairs) {
        if(repairs.getDescbs()==null){
            return RestFulBean.error("故障内容不能为空");
        }
        if(repairs.getFaultImages()==null){
            return RestFulBean.error("故障照片不能为空");
        }
        this.repairsMapper.insert(repairs);//执行数据库的新增语句
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param repairs 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Repairs repairs) {
        this.repairsMapper.update(repairs);//执行数据库的修改语句 根据id 修改
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
        this.repairsMapper.deleteById(id);//执行数据库的删除语句 根据id 删除
         return RestFulBean.succ("删除成功");
    }
    @Override
    public RestFulBean<Map> uploadRepairsFile(Integer id, MultipartFile coverFile) throws Exception {
        String destPath ="D:\\design\\images\\";//自定义一个路径
        // 存图片
        try{//用一个file文件上传的方法上传照片
            FileUtil.saveFile(coverFile, destPath,coverFile.getOriginalFilename());//上传图片的方法
        }
        catch(Exception e){
            return RestFulBean.error("请求异常");
        }
        Map map =new HashMap();//定义一个map对象
        //返回一个完整的本地照片路径用于前端显示
        map.put("url","http://localhost:8087/file/"+coverFile.getOriginalFilename());
        Repairs repairs =new Repairs();
        repairs.setId(id);
        repairs.setRepairsImages(coverFile.getOriginalFilename());  //修改照片
        this.repairsMapper.update(repairs);//执行数据库的修改语句 根据id 修改
        return RestFulBean.succ(map);
    }
}
