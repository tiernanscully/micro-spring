package com.lemur.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.*;

import com.lemur.user.User;

@RestController
public class WebResource {

    @Autowired
    private UserServiceClient userServiceClient;

    @RequestMapping(method = RequestMethod.GET, value = "/users/")
    public Resources<User> getUsers() {
        return userServiceClient.getUsers();
    }

}
