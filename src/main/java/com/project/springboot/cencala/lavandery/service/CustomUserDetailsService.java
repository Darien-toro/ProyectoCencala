package com.project.springboot.cencala.lavandery.service;

import com.project.springboot.cencala.lavandery.entity.UserAccountEntity;
import com.project.springboot.cencala.lavandery.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserAccountRepository userAccountRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccountEntity userAccountEntity = userAccountRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
        return User
                .builder()
                .username(userAccountEntity.getUsername())
                .password(userAccountEntity.getPassword())
                .accountExpired(userAccountEntity.getAccountExpDate() != null && userAccountEntity.getAccountExpDate().isBefore(LocalDate.now()))
                .credentialsExpired(userAccountEntity.getAccountExpDate() != null && userAccountEntity.getAccountExpDate().isBefore(LocalDate.now()))
                .accountLocked(userAccountEntity.getIsAccountLocked())
                .disabled("DISABLED".equals(userAccountEntity.getStatus()))
                .build();
    }
}
