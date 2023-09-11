package com.springboot.security_jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<UserEntity> optionalUserEntity = repository.findByUsername(username);
       return optionalUserEntity.map(CustomUserDetails::new).orElseThrow(()->new UsernameNotFoundException("User with this name doesn't exist"));
    }

}
