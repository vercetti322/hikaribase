package com.app.hikaribase.service;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Getter
@Service
public class TokenService {
    private final String token = UUID.randomUUID().toString();
}
