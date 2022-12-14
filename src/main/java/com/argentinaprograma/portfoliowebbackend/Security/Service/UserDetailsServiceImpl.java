package com.argentinaprograma.portfoliowebbackend.Security.Service;

import com.argentinaprograma.portfoliowebbackend.Security.Model.MainUser;
import com.argentinaprograma.portfoliowebbackend.Security.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getByUsername(username).get();
        System.out.println(user);
        return MainUser.build(user);
    }

}
