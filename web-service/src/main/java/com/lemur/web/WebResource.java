package com.lemur.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.lemur.user.User;

@RestController
public class WebResource {

    @Autowired
    private UserServiceClient userServiceClient;

    @RequestMapping(method = RequestMethod.GET, value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public PagedResources<Resource<User>> getUsers() {
        return userServiceClient.getUsers();
    }

}
