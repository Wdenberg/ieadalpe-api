package com.ieadalpe.ieadalpeapi.security;

import com.ieadalpe.ieadalpeapi.repository.UserCredentialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserCredentialRepository credentialRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var credential = credentialRepository.findByProfileEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado."));

        var profile = credential.getProfile();

        var authorities = profile.getRoles().stream()
                .map(role -> role.getRole().name())
                .map(role -> "ROLE_" + role)
                .map(SimpleGrantedAuthority::new)
                .toList();

        return User.builder()
                .username(profile.getEmail())
                .password(credential.getPasswordHash())
                .authorities(authorities)
                .disabled(!credential.getEnabled())
                .build();
    }
}
