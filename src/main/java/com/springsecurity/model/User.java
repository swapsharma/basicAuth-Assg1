package com.springsecurity.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String userId;
    private String userName;
    private String firstName;
    private String lastName;
    private String password;

}
