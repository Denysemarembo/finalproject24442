package com.Denyse.Final.Project.security;

import com.Denyse.Final.Project.repository.UserRepository;
import com.Denyse.Final.Project.model.Role;
import com.Denyse.Final.Project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//
//    private UserRepository userRepo;
//    @Autowired
//    public CustomUserDetailsService(UserRepository userRepo) {
//        this.userRepo = userRepo;
//    }
//
//
//
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = userRepo.findByEmail(email);
//
//        if (user != null) {
//            return new org.springframework.security.core.userdetails.User(user.getEmail(),
//                    user.getPassword(),
//                    mapRolesToAuthorities(user.getRoles()));
//        }else{
//            throw new UsernameNotFoundException("Invalid username or password.");
//        }
//    }
//
//    private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
//        Collection < ? extends GrantedAuthority> mapRoles = roles.stream()
//                .map(role -> new SimpleGrantedAuthority(role.getName()))
//                .collect(Collectors.toList());
//        return mapRoles;
//    }
//}

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepo;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email);

        if (user != null) {
            return new org.springframework.security.core.userdetails.User(
                    user.getEmail(),
                    user.getPassword(),
                    mapRolesToAuthorities(user.getRoles())
            );
        } else {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}


