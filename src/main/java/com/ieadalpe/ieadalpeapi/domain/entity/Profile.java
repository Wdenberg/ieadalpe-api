package com.ieadalpe.ieadalpeapi.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Profile extends BaseEntity{

    @Id
    private UUID id;

    @Column(name = "name", length = 150)
    private String name;

    @Column(name = "email", length = 150)
    private String email;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @OneToMany(mappedBy = "user")
    @Builder.Default
    private Set<UserRole> roles = new HashSet<>();
}
