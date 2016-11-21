package com.lemur.event.domain;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

@Entity
@Data
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private final String address;
    private final String latitude;
    private final String longitude;
}
