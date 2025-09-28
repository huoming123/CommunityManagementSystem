package com.design.communityManagementSystem.service.impl;

import com.design.communityManagementSystem.mapper.UsersMapper;
import com.design.communityManagementSystem.pojo.Payment;
import com.design.communityManagementSystem.mapper.PaymentMapper;
import com.design.communityManagementSystem.pojo.Users;
import com.design.communityManagementSystem.service.PaymentService;
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
 * (Payment)表服务实现类
 *
 * @author makejava
 */
@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentMapper paymentMapper;
    @Autowired
    private UsersMapper usersMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getList(Page<Payment> page) throws Exception{
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum =page.getPageNum();
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Payment> list= paymentMapper.getPageListByCondition(page);
        if(list.size()>0){  //如果数据大于0 用for循环把照片的完整路劲返回前端显示
            for(Payment payment: list){
                if(payment.getStatus()==1){ //缴费之后 缴费按钮不可编辑
                    payment.setDisabled(true);
                }
                else{
                    payment.setDisabled(false);
                }
            }
        }
        //根据条件查询数据的条数
        Integer count = paymentMapper.getPageListCount(page);
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
    public RestFulBean<Payment> queryById(Integer id) {
       Payment payment=this.paymentMapper.queryById(id);
         return RestFulBean.succ(payment);
    }

    /**
     * 新增数据
     *
     * @param payment 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Payment payment) {
        List<Payment> PaymentList =paymentMapper.queryByYearAndMonth(payment.getMonth(),payment.getYear());
        if(PaymentList.size()>0){
            return RestFulBean.error("该数据已生成收费数据，请不要重复生成");
        }
        List<Users> list =usersMapper.getUserList();
        for(Users users: list ){
            payment.setUserId(users.getId());
            payment.setPropertyFee(users.getArea() *payment.getFee());  //计算物业费
            this.paymentMapper.insert(payment);//执行数据库的新增语句
        }

        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param payment 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Payment payment) {
        this.paymentMapper.update(payment);//执行数据库的修改语句 根据id 修改
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
        this.paymentMapper.deleteById(id);//执行数据库的删除语句 根据id 删除
         return RestFulBean.succ("删除成功");
    }
}
