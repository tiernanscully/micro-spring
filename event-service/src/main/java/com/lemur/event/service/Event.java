package com.lemur.event.service;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.*;

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
