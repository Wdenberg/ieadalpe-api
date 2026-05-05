package com.ieadalpe.ieadalpeapi.domain.entity;


import com.ieadalpe.ieadalpeapi.config.BaseEntity;
import com.ieadalpe.ieadalpeapi.domain.enums.AppRole;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Entity
@Table(name = "user_roles",
        uniqueConstraints = {
        @UniqueConstraint(name = "uk_user_roles_user_roles",
                columnNames = {"user_id", "role"})})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRole extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Profile user;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, length = 20)
    private AppRole role;
}
