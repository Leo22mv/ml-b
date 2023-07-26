package com.ml.mlbs.service;

import java.util.List;

import com.ml.mlbs.model.UserEntity;

public interface IUserService {
    public List<UserEntity> getUsers();
    public void saveUser (UserEntity user);
    public UserEntity findUser (Long id);
}

