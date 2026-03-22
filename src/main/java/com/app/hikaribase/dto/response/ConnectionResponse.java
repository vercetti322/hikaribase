package com.app.hikaribase.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConnectionResponse {
    private Integer id;
    private String name;
    private String host;
    private Integer port;
    private String username;
    private String createdTimeStamp;
}
