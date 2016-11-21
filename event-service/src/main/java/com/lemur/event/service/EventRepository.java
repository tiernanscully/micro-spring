package com.lemur.event.service;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "events", path = "events")
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {

	List<Event> findAll();
	Event findEventByEventId(@Param("eventId") final Long eventId);
	List<Event> findEventByActivityTypeIgnoreCase(@Param("activityType") final String type);
}
