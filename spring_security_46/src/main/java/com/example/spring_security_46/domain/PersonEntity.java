package com.example.spring_security_46.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.FetchType.*;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "persons")
public class PersonEntity implements UserDetails {

    @Id
    @UuidGenerator
    private UUID id;

    private String login;

    private String password;

    @OneToMany(mappedBy = "person", fetch = EAGER, cascade = ALL)
    private List<PermEntity> perms;

    private boolean notBlocked;


    public PersonEntity addPerm(PermEntity perm) {
        if (perms == null) {
            perms = new ArrayList<>();
        }
        perms.add(perm);
        perm.setPerson(this);
        return this;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (perms == null || perms.isEmpty()) {
            return List.of();
        }
        var list = new ArrayList<GrantedAuthority>();
        for (var perm : perms) {
            var auth = new SimpleGrantedAuthority(perm.getName());
            list.add(auth);
        }
        return list;
    }

    @Override
    public String getUsername() {   //есть геттер для этого поля(через lombook)
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {               //default
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {                 //default
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {                 //default
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return notBlocked;
    }
}
