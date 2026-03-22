package com.app.hikaribase.controller;

import com.app.hikaribase.config.ApiConstants;
import com.app.hikaribase.service.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {

    private final TokenService tokenService;

    @Operation(
            summary = "Auth Management",
            description = "Get a new token for bearer authentication"
    )
    @GetMapping("/token")
    public Map<String, String> getToken() {
        return Map.of(ApiConstants.TOKEN_KEY, tokenService.getToken());
    }
}
