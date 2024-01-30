package com.example.userAuth.AulaAutenticacao.model;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.Set;

@Getter
@Service
@Entity
@Table(name = "usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String cpf;
    private String nickname;
    private String password;

    @ManyToMany
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

}
