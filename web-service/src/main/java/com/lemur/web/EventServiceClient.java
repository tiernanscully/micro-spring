package com.lemur.web;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lemur.event.service.Event;

@FeignClient("event-service")
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
public interface EventServiceClient {

	@RequestMapping(method = RequestMethod.GET, value = "/events")
	PagedResources<Resource<Event>> getEvents();

	@RequestMapping(method = RequestMethod.GET, value = "/events/{eventId}")
	Resource<Event> getEventById(@PathVariable("eventId") final long eventId);

	@RequestMapping(method = RequestMethod.GET, value = "/events/search")
	Resource<String> searchApi();
}
