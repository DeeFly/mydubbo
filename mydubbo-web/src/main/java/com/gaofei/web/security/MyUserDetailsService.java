package com.gaofei.web.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by GaoQingming on 2018/4/9 0009.
 */
public class MyUserDetailsService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUserDetailAdaptor myUserDetail = new MyUserDetailAdaptor();
        return myUserDetail;
    }

}
