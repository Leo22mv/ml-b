package com.ml.mlbs.controller.request;

import java.util.Set;

import com.ml.mlbs.model.RoleEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDTO {
    private String email;
    private String nombre;
    private String username;
    private String password;
    private Set<String> roles;
}
