package com.example.fortlomtsp.backend.security.service;
import com.example.fortlomtsp.backend.domain.model.entity.UserAccount;
import com.example.fortlomtsp.backend.domain.service.UserAccountService;
import com.example.fortlomtsp.backend.security.Principal.PrincipalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsImpl implements UserDetailsService{


    @Autowired
    UserAccountService userAccountService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserAccount>value=userAccountService.getbyNombreUsuarioOrEmail(username);
        if (value.isPresent()){
            return PrincipalUser.build(value.get());
        }
        throw new UsernameNotFoundException("Error");
    }
}
