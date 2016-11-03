package com.lemur.web;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lemur.user.User;

@FeignClient("user-service")
public interface UserServiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    Resources<User> getUsers();
}
