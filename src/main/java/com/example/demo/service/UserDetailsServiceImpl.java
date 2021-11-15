package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.UserDAO;


import java.util.ArrayList;
import java.util.List;
import com.example.demo.models.User;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserDAO userdao;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userdao.findByUsername(userName);

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().toString());
        grantList.add(authority);

        UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), grantList);

        return userDetails;
    }

}