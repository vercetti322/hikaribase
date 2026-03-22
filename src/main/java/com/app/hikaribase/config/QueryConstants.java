package com.app.hikaribase.config;

public class QueryConstants {
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
                name TEXT NOT NULL,
                host TEXT NOT NULL,
                port INTEGER NOT NULL,
                username TEXT NOT NULL,
                encrypted_password TEXT NOT NULL
            )""";
}
