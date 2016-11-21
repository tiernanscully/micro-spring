package com.lemur.event.service;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Data
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long eventId;
    private final String eventName;
    private final String eventDescription;
    private final String activityType;
    private final String eventStartTime;
    private final String eventEndTime;
    private final int availableSpaces;
}
