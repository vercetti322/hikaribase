package com.app.hikaribase.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TokenService {

    private final String TOKEN = UUID.randomUUID().toString();

    /**
     * Get a new token at the start of service
     * @return token
     */
    public String getToken() {
        return TOKEN;
    }
}
