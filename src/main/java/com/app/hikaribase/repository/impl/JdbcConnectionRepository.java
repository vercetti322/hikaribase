package com.app.hikaribase.repository.impl;

import com.app.hikaribase.config.ApiConstants;
import com.app.hikaribase.config.QueryConstants;
import com.app.hikaribase.model.ConnectionDetails;
import com.app.hikaribase.repository.ConnectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class JdbcConnectionRepository implements ConnectionRepository {

    private final NamedParameterJdbcTemplate template;

    @Override
    public int save(ConnectionDetails details) {
        var params = new MapSqlParameterSource()
                .addValue(ApiConstants.NAME, details.getName())
                .addValue(ApiConstants.HOST, details.getHost())
                .addValue(ApiConstants.PORT, details.getPort())
                .addValue(ApiConstants.USERNAME, details.getUsername())
                .addValue(
                        ApiConstants.ENCRYPTED_PASSWORD,
                        details.getEncryptedPassword()
                ).addValue(
                        ApiConstants.CREATED_TIMESTAMP,
                        details.getCreatedTimeStamp()
                );
        System.out.println("params " + params);
        var keyHolder = new GeneratedKeyHolder();
        template.update(
                QueryConstants.INSERT_CONNECTION_DETAILS,
                params, keyHolder
        );
        return Objects.requireNonNull(
                keyHolder.getKey()).intValue();
    }
}
