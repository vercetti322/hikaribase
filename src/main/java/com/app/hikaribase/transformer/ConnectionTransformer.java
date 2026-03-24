package com.app.hikaribase.transformer;

import com.app.hikaribase.dto.request.ConnectionCreateRequest;
import com.app.hikaribase.dto.response.ConnectionResponse;
import com.app.hikaribase.model.ConnectionDetails;
import com.app.hikaribase.utility.CryptoUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class ConnectionTransformer {

    private final CryptoUtil cryptoUtil;

    /**
     * Transform incoming new connection details to row data for
     * insertion into database
     *
     * @param request new connection details
     * @return connection details for SQLite
     */
    public ConnectionDetails toEntity(ConnectionCreateRequest request) {
        var encryptedPassword = cryptoUtil.encrypt(request.getPassword());
        var createdTimeStamp = LocalDateTime.now().toString();

        return ConnectionDetails.builder().name(request.getName())
                .host(request.getHost()).port(request.getPort())
                .username(request.getUsername()).encryptedPassword(encryptedPassword)
                .createdTimeStamp(createdTimeStamp).build();
    }

    /**
     * Transform newly persisted connection details in table
     * to response object for client
     *
     * @param id newly generated unique id for connection
     * @param details connection details from SQLite
     * @return response for new connection creation
     */
    public ConnectionResponse toResponse(int id, ConnectionDetails details) {
        return ConnectionResponse.builder().id(id).name(details.getName())
                .host(details.getHost()).port(details.getPort())
                .username(details.getUsername()).build();
    }
}
