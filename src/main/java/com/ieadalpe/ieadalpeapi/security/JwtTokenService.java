package com.ieadalpe.ieadalpeapi.security;

import com.ieadalpe.ieadalpeapi.config.JwtProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JwtTokenService {

    private final JwtEncoder jwtEncoder;
    private final JwtProperties jwtProperties;

    public TokenData generateToken(org.springframework.security.core.userdetails.UserDetails userDetails) {
        Instant now = Instant.now();
        Instant expiresAt = now.plusSeconds(jwtProperties.expiration());

        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .map(auth -> auth.replace("ROLE_", ""))
                .toList();

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer(jwtProperties.issuer())
                .issuedAt(now)
                .expiresAt(expiresAt)
                .subject(userDetails.getUsername())
                .claim("roles", roles)
                .build();

        JwsHeader jwsHeader = JwsHeader.with(() -> "HS256").build();

        String token = jwtEncoder.encode(JwtEncoderParameters.from(jwsHeader, claims)).getTokenValue();

        return new TokenData(token, now, expiresAt, jwtProperties.expiration());
    }

    public record TokenData(
            String accessToken,
            Instant issuedAt,
            Instant expiresAt,
            long expiresIn
    ) {}
}