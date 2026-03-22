package com.app.hikaribase.config;

import java.util.List;

public class ApiConstants {
    public static final String TOKEN_KEY = "token";
    public static final String AUTHORIZATION_KEY = "Authorization";
    public static final String BEARER_KEY = "Bearer ";
    public static final String TOKEN_PATH = "/api/token";
    public static final String V3_API_DOCS_PATH = "/v3/api-docs";
    public static final String V3_API_DOCS_PATHS = "/v3/api-docs/**";
    public static final String SWAGGER_UI_PATH = "/swagger-ui";
    public static final String SWAGGER_UI_PATHS = "/swagger-ui/**";
    public static final List<String> FILTER_AUTH_EXCLUDE_LIST = List.of(
            TOKEN_PATH, V3_API_DOCS_PATH, SWAGGER_UI_PATH
    );
    public static final List<String> SECURITY_AUTH_EXCLUDE_LIST = List.of(
            TOKEN_PATH, V3_API_DOCS_PATHS, SWAGGER_UI_PATHS
    );
}
