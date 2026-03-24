package com.app.hikaribase.config;

public class QueryConstants {
    private QueryConstants() {}
    public static final String CREATE_LLM_CREDENTIALS_TABLE
            = """
            CREATE TABLE IF NOT EXISTS llm_credentials (
                llm_provider TEXT PRIMARY KEY,
                encrypted_key TEXT NOT NULL
            )
            """;
    public static final String CREATE_CONNECTION_DETAILS_TABLE
            = """
            CREATE TABLE IF NOT EXISTS connection_details (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL UNIQUE,
                host TEXT NOT NULL,
                port INTEGER NOT NULL,
                username TEXT NOT NULL,
                encrypted_password TEXT NOT NULL,
                created_time_stamp TEXT NOT NULL,
                updated_time_stamp TEXT,
                UNIQUE (host, port, username)
            )""";
    public static final String TEST_MYSQL_CONNECTION = "SELECT 1";
    public static final String INSERT_CONNECTION_DETAILS
            = """
            INSERT INTO connection_details (
                name, host, port,
                username, encrypted_password,
                created_time_stamp, updated_time_stamp
            ) VALUES (
                :name, :host, :port, :username,
                :encrypted_password, :created_time_stamp, NULL
            )""";
}
