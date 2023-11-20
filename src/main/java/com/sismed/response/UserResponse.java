package com.sismed.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserResponse {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<String> roles;
}
