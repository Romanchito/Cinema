package com.cinema.services;

import com.cinema.dao.UserDaoImpl;
import com.cinema.entities.Enums.Roles;
import com.cinema.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger logger = Logger.getLogger(UserDetailsServiceImpl.class.getName());

    @Autowired
    private UserDaoImpl userDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        logger.info("------------------------------------ТФФФФФФФФФФФФФФФЬ " + name);

        User user = userDao.findByName(name);

        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
            roles.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));


        for(GrantedAuthority role : roles){
            logger.info("------------------------------------AAAAAAAAAAAAAAAAAA " + user.getName());
            logger.info("------------------------------------AAAAAAAAAAAAAAAAAA " + user.getRole());
            logger.info("------------------------------------AAAAAAAAAAAAAAAAAA " + role.toString());
        }

        return new org.springframework.security.core.userdetails.User(user.getName() , user.getPassword() , roles);
    }
}
