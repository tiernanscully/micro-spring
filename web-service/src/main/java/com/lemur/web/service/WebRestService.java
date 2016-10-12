package com.lemur.web.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lemur.user.domain.User;


public interface WebRestService {

	@RequestMapping(method = RequestMethod.GET, value ="/{id}")
	public String getId(@PathVariable("id") final String id);

	@RequestMapping(method = RequestMethod.GET, value ="/users/{id}")
	public User getUser(@PathVariable("id") final String id);

	@RequestMapping(method = RequestMethod.GET, value ="/")
	String index();
}
