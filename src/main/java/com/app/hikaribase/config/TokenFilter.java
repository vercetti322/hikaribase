package com.app.hikaribase.config;

import com.app.hikaribase.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class TokenFilter extends OncePerRequestFilter {

    private final TokenService tokenService;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        // allow token & api doc endpoints without auth
        boolean isExcluded = ApiConstants.FILTER_AUTH_EXCLUDE_LIST.stream()
                .anyMatch(request.getRequestURI()::startsWith);

        if (isExcluded) {
            filterChain.doFilter(request, response);
            return;
        }

        String header = request.getHeader(ApiConstants.AUTHORIZATION_KEY);
        if (header == null || !header.equals(
                ApiConstants.BEARER_KEY + tokenService.getToken()
        )) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        filterChain.doFilter(request, response);
    }
}
