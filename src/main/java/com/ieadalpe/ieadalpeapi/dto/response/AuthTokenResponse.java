package com.ieadalpe.ieadalpeapi.dto.response;

import java.time.Instant;

public record AuthTokenResponse(
        String accessToken,
        String tokenType,
        long expiresIn,
        Instant issuedAt,
        Instant expiresAt
) {
}
