package com.foodconference.foodconference.services.impl;

import com.foodconference.foodconference.models.User;
import com.foodconference.foodconference.repositories.UserRepository;
import com.foodconference.foodconference.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public Optional<User> findByUsername(String username) {
        Optional<User> byUsername = userRepository.findByUsername(username);
        return byUsername;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), user.getUserRoles().stream().map(userRole -> new SimpleGrantedAuthority(userRole.getAuthority())).collect(Collectors.toList()));

    }
}
