package com.foodconference.foodconference.controllers;

import com.foodconference.foodconference.dto.JwtRequest;
import com.foodconference.foodconference.dto.JwtResponse;
import com.foodconference.foodconference.services.impl.UserServiceImpl;
import com.foodconference.foodconference.utils.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@CrossOrigin("http://localhost:3000/")
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final UserServiceImpl userService;
    private final JwtTokenUtils jwtTokenUtils;


    @PostMapping("/auth")

    public ResponseEntity<?> createToken(@RequestBody JwtRequest jwtRequest) {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>("Wrong Username", HttpStatus.UNAUTHORIZED);
        }
        UserDetails userDetails = userService.loadUserByUsername(jwtRequest.getUsername());
        String token = jwtTokenUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }
}
