package org.example.haddaniabderazakexamapp.controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private JwtEncoder jwtEncoder;
    private AuthenticationManager authenticationManager;

    @GetMapping("/profile")
    public Authentication infos(Authentication authentication) {
        return authentication;
    }

    @PostMapping("/login")
    public Map<String, String> token(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        Instant now = Instant.now();
        String scope = authentication.getAuthorities()
                .stream().map(auth -> auth.getAuthority())
                .collect(Collectors.joining(" "));
        JwtClaimsSet jwtClaimsSet = JwtClaimsSet.builder()
                .issuedAt(now)
                .subject(authentication.getName())
                .expiresAt(now.plus(5, ChronoUnit.MINUTES))
                .claim("scope", scope)
                .build();
        JwtEncoderParameters jwtEncoderParameters =
                JwtEncoderParameters.from(
                        JwsHeader.with(MacAlgorithm.HS512).build(),
                        jwtClaimsSet
                );
        Jwt jwt = jwtEncoder.encode(jwtEncoderParameters);
        return Map.of("access-token", jwt.getTokenValue());
    }
}
