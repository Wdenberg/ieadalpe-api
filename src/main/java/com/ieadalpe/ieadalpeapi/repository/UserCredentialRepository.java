package com.ieadalpe.ieadalpeapi.repository;

import com.ieadalpe.ieadalpeapi.domain.entity.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserCredentialRepository extends JpaRepository<UserCredential, UUID> {
    Optional<UserCredential> findByProfileEmail(String email);
}
