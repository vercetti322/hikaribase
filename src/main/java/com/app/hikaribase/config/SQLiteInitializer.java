package com.app.hikaribase.config;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class SQLiteInitializer {

    private final JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        createTables();
    }

    private void createTables() {
        jdbcTemplate.execute(
                QueryConstants.CREATE_LLM_CREDENTIALS_TABLE
        );

        jdbcTemplate.execute(
                QueryConstants.CREATE_CONNECTION_DETAILS_TABLE
        );
    }
}
