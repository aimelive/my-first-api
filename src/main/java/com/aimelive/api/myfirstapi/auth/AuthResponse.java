package com.aimelive.api.myfirstapi.auth;

import com.aimelive.api.myfirstapi.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    private String message;
    private User data;
    private String token;
}
