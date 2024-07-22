package com.storm.desafio_projeto_api_rest_na_nuvem.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.storm.desafio_projeto_api_rest_na_nuvem.domain.model.User;
import com.storm.desafio_projeto_api_rest_na_nuvem.domain.repository.UserRepository;
import com.storm.desafio_projeto_api_rest_na_nuvem.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User createUser(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This account number already exists.");
        }
        return userRepository.save(userToCreate);
    }
}
