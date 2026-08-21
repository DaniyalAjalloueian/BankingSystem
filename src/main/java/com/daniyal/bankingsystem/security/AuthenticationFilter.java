//package com.daniyal.bankingsystem.security;
//
//import com.daniyal.bankingsystem.service.ApiKeyService;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.jspecify.annotations.NonNull;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.util.List;
//
//@Component  (disabled api key)
//public class AuthenticationFilter extends OncePerRequestFilter {
//
//    private final ApiKeyService apiKeyService;
//
//    public AuthenticationFilter(ApiKeyService apiKeyService) {
//        this.apiKeyService = apiKeyService;
//    }
//
//    @Override
//    protected void doFilterInternal(
//            HttpServletRequest request,
//            @NonNull HttpServletResponse response,
//            @NonNull FilterChain filterChain
//    ) throws ServletException, IOException {
//
//        String path = request.getServletPath();
//
//        if (path.equals("/api/auth/register")) {
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//        String apiKey = request.getHeader("X-API-KEY");
//
//        if (apiKey == null || !apiKeyService.isValid(apiKey)) {
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            return;
//        }
//
//        UsernamePasswordAuthenticationToken authentication =
//                new UsernamePasswordAuthenticationToken(
//                        "api-user",
//                        null,
//                        List.of()
//                );
//
//        SecurityContextHolder.getContext()
//                .setAuthentication(authentication);
//
//        filterChain.doFilter(request, response);
//    }
//}