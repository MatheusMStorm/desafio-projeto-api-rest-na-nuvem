package com.storm.desafio_projeto_api_rest_na_nuvem.service;

import com.storm.desafio_projeto_api_rest_na_nuvem.domain.model.User;

public interface UserService {

    User findById(Long id);
    User createUser(User userToCreate);
    
}
