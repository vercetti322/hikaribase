package com.app.hikaribase.service;

import com.app.hikaribase.config.ApiConstants;
import com.app.hikaribase.config.QueryConstants;
import com.app.hikaribase.dto.request.ConnectionRequest;
import com.app.hikaribase.dto.response.ConnectionResponse;
import com.app.hikaribase.exception.ConnectionTestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.DriverManager;
import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class ConnectionService {
    public ConnectionResponse createConnection(ConnectionRequest request) {
        String url = ApiConstants.JDBC_MYSQL_PREFIX + request.getHost() +
                ":" + request.getPort() + "/" + ApiConstants.DEFAULT_MYSQL_DB;

        testServerConnection(url, request.getUsername(), request.getPassword());
        // TODO: persist in database and return the response
        return ConnectionResponse.builder().build();
    }

    private void testServerConnection(String url, String username, String password) {
        DriverManager.setLoginTimeout(ApiConstants.TEST_CONNECTION_TIMEOUT);

        try (var connection = DriverManager.getConnection(url, username, password);
             var stmt = connection.createStatement()
        ) {
            stmt.execute(QueryConstants.TEST_MYSQL_CONNECTION);
        } catch (SQLException e) {
            throw new ConnectionTestException(e);
        }
    }
}
