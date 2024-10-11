package com.example.spring_security_46.service;

import com.example.spring_security_46.domain.PermEntity;
import com.example.spring_security_46.domain.PersonEntity;
import com.example.spring_security_46.dto.PersonDto;
import com.example.spring_security_46.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonDetailsService implements UserDetailsService {

    private final PersonRepository personRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<PersonEntity> personOpt = personRepo.findByLogin(username);
        if (personOpt.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }

        return personOpt.get();
    }

    public void save(PersonDto personDto) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setLogin(personDto.getLogin());
        personEntity.setPassword(passwordEncoder.encode(personDto.getPassword()));
        personEntity.setNotBlocked(true);  // обязательно указать это поле как "true", если пользователь не заблокирован
        PermEntity perm = new PermEntity();
        perm.setName(personDto.getRole());
        personEntity.addPerm(perm);
        personRepo.save(personEntity);
    }
}
