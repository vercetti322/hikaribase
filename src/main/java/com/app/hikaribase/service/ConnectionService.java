package com.app.hikaribase.service;

import com.app.hikaribase.config.ApiConstants;
import com.app.hikaribase.config.QueryConstants;
import com.app.hikaribase.dto.request.ConnectionCreateRequest;
import com.app.hikaribase.dto.response.ConnectionResponse;
import com.app.hikaribase.exception.ConnectionTestException;
import com.app.hikaribase.repository.ConnectionRepository;
import com.app.hikaribase.transformer.ConnectionTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.DriverManager;
import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class ConnectionService {

    private final ConnectionRepository repository;
    private final ConnectionTransformer transformer;

    /**
     * Validating a new connection from request details
     * and persisting it in SQLite database
     *
     * @param request new connection details
     * @return response for connection create request
     */
    public ConnectionResponse createConnection(ConnectionCreateRequest request) {
        String url = ApiConstants.JDBC_MYSQL_PREFIX + request.getHost() +
                ":" + request.getPort() + "/" + ApiConstants.DEFAULT_MYSQL_DB;

        testServerConnection(url, request.getUsername(), request.getPassword());
        var connectionDetails = transformer.toEntity(request);

        int id = repository.save(connectionDetails);
        return transformer.toResponse(id, connectionDetails);
    }

    /**
     * Testing connection to MySQL server & running a test query
     *
     * @param url MySQL server address
     * @param username MySQL username
     * @param password MySQL password
     */
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
