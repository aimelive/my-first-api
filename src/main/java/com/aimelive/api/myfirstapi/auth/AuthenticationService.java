package com.aimelive.api.myfirstapi.auth;

import com.aimelive.api.myfirstapi.config.JwtService;
import com.aimelive.api.myfirstapi.user.Role;
import com.aimelive.api.myfirstapi.user.User;
import com.aimelive.api.myfirstapi.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;
    public AuthResponse register(RegisterRequest registerRequest) {
        Optional<User> userByEmail = repository.findUserByEmail(registerRequest.getEmail());

        if(userByEmail.isPresent()){
            throw new IllegalStateException("Email taken");
        }
        var user = User.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .email(registerRequest.getEmail())
                .dob(registerRequest.getDob())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.USER)
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
                .message("User registered successfully!")
                .data(user)
                .token(jwtToken)
                .build();
    }

    public AuthResponse login(LoginRequest loginRequest) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );
        var user = repository.findUserByEmail(loginRequest.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
                .message("User logged in successfully!")
                .data(user)
                .token(jwtToken)
                .build();
    }
}
