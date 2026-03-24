package com.app.hikaribase.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConnectionDetails {
    private Integer id;
    private String name;
    private String host;
    private Integer port;
    private String username;
    private String encryptedPassword;
    private String createdTimeStamp;
    private String updatedTimeStamp;
}
