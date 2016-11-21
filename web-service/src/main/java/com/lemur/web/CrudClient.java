package com.lemur.web;

import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface CrudClient<T> {
	
    @RequestMapping(method = RequestMethod.POST, value = "/")
    long save(T entity);
 
    @RequestMapping(method = RequestMethod.GET, value = "/")
	PagedResources<Resource<T>> getEvents();
    
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    void update(@PathVariable("id") long id, T entity);

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    Resource<T> get(@PathVariable("id") long id);

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    void delete(@PathVariable("id") long id);
    
	@RequestMapping(method = RequestMethod.GET, value = "/search")
	Resource<String> searchApi();
}