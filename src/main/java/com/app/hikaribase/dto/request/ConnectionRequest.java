package com.app.hikaribase.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConnectionRequest {

    @NotBlank(message = "name cannot be blank")
    private String name;

    @NotBlank(message = "name cannot be blank")
    private String host;

    @NotNull(message = "port cannot be null")
    private Integer port;

    @NotBlank(message = "username cannot be blank")
    private String username;

    @NotBlank(message = "password cannot be blank")
    private String password;
}
