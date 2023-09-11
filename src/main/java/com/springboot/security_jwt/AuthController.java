package com.springboot.security_jwt;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/app")
public class AuthController {

    private final UserService userService;
    private final JwtTokenUtil jwtTokenUtil;

    @Autowired
    public AuthController(UserService userService, JwtTokenUtil jwtTokenUtil) {
        this.userService = userService;
        this.jwtTokenUtil = jwtTokenUtil;

    }


    @PostMapping("/login")
    public ResponseEntity<?> logIn(@RequestBody JwtRequest authRequest) {

        AppUser appUser = userService.loadUserByUsername(authRequest.getUsername());
        if(appUser.getPassword().equals(authRequest.getPassword())){
            String token = jwtTokenUtil.generateToken(authRequest.getUsername());
            HttpHeaders headers = new HttpHeaders();
            headers.add("Auth", token);
            return ResponseEntity.ok().headers(headers).body("Authentication is successful");
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


}
