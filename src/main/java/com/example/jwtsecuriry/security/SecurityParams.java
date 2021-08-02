package com.example.jwtsecuriry.security;

public class SecurityParams {
    public static final String JWT_HEADER_NAME = "Authorization";
    public static final String SECRET = "oumayma@ma.uca";
    public static final long EXPIRATION = 864_000_000; //10 days
    public static final String HEADER_PREFIX = "Bearer ";
}
