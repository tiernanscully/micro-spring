package com.lemur.web;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lemur.user.User;

@FeignClient("user-service")
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
public interface UserServiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    PagedResources<Resource<User>> getUsers();
}
