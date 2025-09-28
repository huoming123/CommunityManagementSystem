package com.design.communityManagementSystem.service;

import com.design.communityManagementSystem.pojo.res.RestFulBean;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface UpLoadService {
    RestFulBean<Map> upload(MultipartFile coverFile);
}
