package com.lemur.web.feign.client;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.lemur.user.service.UserRestService;

@FeignClient("user-service")
public interface UserServiceClient extends UserRestService{
}
