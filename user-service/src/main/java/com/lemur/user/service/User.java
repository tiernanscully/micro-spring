package com.lemur.user.service;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

@Entity
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private final String username;
    private final String firstName;
    private final String lastName;
    private final String phoneNumber;
    private final String emailAddress;

}
