package com.ieadalpe.ieadalpeapi.repository;

import com.ieadalpe.ieadalpeapi.domain.entity.UserRole;
import com.ieadalpe.ieadalpeapi.domain.enums.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRoleRepository extends JpaRepository<UserRole, UUID> {

    List<UserRole> findByUserId(UUID id);
    boolean existsByUserIdAndRole(UUID userId, AppRole role);
}
