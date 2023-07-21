package com.ml.mlbs.service;

import java.util.List;

import com.ml.mlbs.model.User;

public interface IUserService {
    public List<User> getUsers();
    public void saveUser (User user);
    public User findUser (Long id);
}

