package com.design.communityManagementSystem.controller;

import com.design.communityManagementSystem.dto.Page;
import com.design.communityManagementSystem.pojo.Message;
import com.design.communityManagementSystem.pojo.res.RestFulBean;
import com.design.communityManagementSystem.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * (Message)表控制层
 *
 * @author makejava
 * @since  19:23:04
 */
@RestController
@RequestMapping("/message")
public class MessageController {
    /**
     * 服务对象
     */
    @Autowired
    private MessageService messageService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<Message>page) throws Exception{
        return this.messageService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<Message> queryById(@RequestBody Message message) {
        return this.messageService.queryById(message.getId());
    }

    /**
     * 新增数据
     *
     * @param message 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Message message) {
        return this.messageService.insert(message);
    }

    /**
     * 编辑数据
     *
     * @param message 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Message message) {
        return this.messageService.update(message);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Message message) {
        return this.messageService.deleteById(message.getId());
    }

}

