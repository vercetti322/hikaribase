package com.app.hikaribase.controller;

import com.app.hikaribase.dto.request.ConnectionRequest;
import com.app.hikaribase.dto.response.ConnectionResponse;
import com.app.hikaribase.service.ConnectionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/api/connections")
@RequiredArgsConstructor
public class ConnectionController {

    private final ConnectionService service;

    @PostMapping
    public ResponseEntity<ConnectionResponse> createConnection(
            @Valid @RequestBody ConnectionRequest request
    ) {
        var response = service.createConnection(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
