package com.design.communityManagementSystem.controller;

import com.design.communityManagementSystem.pojo.Payment;
import com.design.communityManagementSystem.service.PaymentService;
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
 * (Payment)表控制层
 *
 * @author makejava
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {
    /**
     * 服务对象
     */
    @Autowired
    private PaymentService paymentService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<Payment>page) throws Exception{
        return this.paymentService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<Payment> queryById(@RequestBody Payment payment) {
        return this.paymentService.queryById(payment.getId());
    }

    /**
     * 新增数据
     *
     * @param payment 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Payment payment) {
        return this.paymentService.insert(payment);
    }

    /**
     * 编辑数据
     *
     * @param payment 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Payment payment) {
        return this.paymentService.update(payment);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Payment payment) {
        return this.paymentService.deleteById(payment.getId());
    }

}

