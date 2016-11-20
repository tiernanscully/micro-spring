package com.lemur.web;

import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.lemur.event.service.Event;
import com.lemur.user.service.User;

@RestController
public class WebResource {

    @Autowired
    private UserServiceClient userServiceClient;
    
    @Autowired
    private EventServiceClient eventServiceClient;

    @RequestMapping(method = RequestMethod.GET, value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public PagedResources<Resource<User>> getUsers() {
        return userServiceClient.getUsers();
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/users/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource<User> getUserById(@PathParam("userId")final String userId) {
        return userServiceClient.getUserById(userId);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/users/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource<String> getUsersApi() {
        return userServiceClient.searchApi();
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/events", produces = MediaType.APPLICATION_JSON_VALUE)
    public PagedResources<Resource<Event>> getEvents() {
        return eventServiceClient.getEvents();
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/events/{eventId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource<Event> getEventById(@PathParam("eventId")final String eventId) {
        return eventServiceClient.getEventById(eventId);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/events/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource<String> getEventsApi() {
        return eventServiceClient.searchApi();
    }

}
