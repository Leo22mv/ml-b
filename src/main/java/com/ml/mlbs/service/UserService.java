package com.ml.mlbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ml.mlbs.model.UserEntity;
import com.ml.mlbs.repository.UserRepository;

@Service
public class UserService implements IUserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(UserEntity user) {
        userRepository.save(user);
    }

    @Override
    public UserEntity findUser(Long id) {
        UserEntity user = userRepository.findById(id).orElse(null);
        return user;
    }

    @Override
    public List<UserEntity> getUsers() {
       List<UserEntity> listaUsers = (List<UserEntity>) userRepository.findAll();
       return listaUsers; 
    }
}
