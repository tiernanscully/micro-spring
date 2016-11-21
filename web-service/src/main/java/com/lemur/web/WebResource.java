package com.lemur.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
    public Resource<User> getUserById(@PathVariable final long userId) {
        return userServiceClient.getUserById(userId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource<String> getUsersApi() {
        return userServiceClient.searchApi();
    }

    // @RequestMapping(method = RequestMethod.GET, value = "/events", produces =
    // MediaType.APPLICATION_JSON_VALUE)
    // public PagedResources<Resource<Event>> getEvents() {
    // return eventServiceClient.getEvents();
    // }
    //
    // @RequestMapping(method = RequestMethod.GET, value = "/events/{eventId}",
    // produces = MediaType.APPLICATION_JSON_VALUE)
    // public Resource<Event> getEventById(@PathVariable final long
    // eventId) {
    // return eventServiceClient.getEventById(eventId);
    // }

    @RequestMapping(method = RequestMethod.GET, value = "/events/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource<String> getEventsApi() {
        return eventServiceClient.searchApi();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource<String> getApi() {
        // final Resource<String> eventApi = eventServiceClient.searchApi();
        final Resource<String> userApi = userServiceClient.searchApi();
        final List<Link> links = new ArrayList<>();
        // links.addAll(eventApi.getLinks());
        links.addAll(userApi.getLinks());
        return new Resource<>("Rest API", links);
    }

}
