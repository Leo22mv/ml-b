package com.ml.mlbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ml.mlbs.model.User;
import com.ml.mlbs.repository.UserRepository;

@Service
public class UserService implements IUserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User findUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return user;
    }

    @Override
    public List<User> getUsers() {
       List<User> listaUsers = userRepository.findAll();
       return listaUsers; 
    }
}
