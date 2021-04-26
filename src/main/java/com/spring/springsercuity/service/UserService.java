package com.spring.springsercuity.service;

import com.spring.springsercuity.mapper.UserInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : userInfoMapper.fingUserRoleByName(username)
             ) {
            authorities.add(new SimpleGrantedAuthority(role));
            log.info(role);
        }

           return new User(
                   (String) userInfoMapper.findUserByName(username).get("username"),
                   (String) userInfoMapper.findUserByName(username).get("password"),
                   authorities
        );
    }
}
