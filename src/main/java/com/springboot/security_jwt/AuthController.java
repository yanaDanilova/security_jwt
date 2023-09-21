package com.springboot.security_jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationService authenticationService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Autowired
    public AuthController(AuthenticationService authenticationService, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.authenticationService = authenticationService;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }
    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
    }


}
