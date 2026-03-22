package com.app.hikaribase.repository.impl;

import com.app.hikaribase.config.QueryConstants;
import com.app.hikaribase.model.ConnectionDetails;
import com.app.hikaribase.repository.ConnectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JdbcConnectionRepository implements ConnectionRepository {

    private final JdbcTemplate template;

    @Override
    public void save(ConnectionDetails details) {
        template.update(
                QueryConstants.INSERT_CONNECTION_DETAILS
        );
    }
}
