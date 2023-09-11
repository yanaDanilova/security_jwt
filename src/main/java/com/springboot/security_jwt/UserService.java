package com.springboot.security_jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserService  {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public AppUser loadUserByUsername(String username)  {
        return  userRepository.findByUsername(username);

    }
}
