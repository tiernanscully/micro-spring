package com.lemur.user.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lemur.user.domain.User;

public interface UserRestService {

	@RequestMapping(method = RequestMethod.GET, value = "/{userId}")
    public User getUser(@PathVariable("userId") final String userId);

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String index();
}
