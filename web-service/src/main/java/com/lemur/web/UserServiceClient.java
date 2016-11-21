package com.lemur.web;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.lemur.user.service.User;

@FeignClient("user-service")
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
public interface UserServiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    PagedResources<Resource<User>> getUsers();

    @RequestMapping(method = RequestMethod.GET, value = "/users/{userId}")
    Resource<User> getUserById(@PathVariable("userId") final long userId);

    @RequestMapping(method = RequestMethod.GET, value = "/users/search")
    Resource<String> searchApi();
}
