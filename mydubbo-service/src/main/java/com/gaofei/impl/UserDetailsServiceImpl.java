package com.gaofei.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.gaofei.dto.UserSession;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;

/**
 * Created by GaoQingming on 2018/7/16 0016.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserSession result = new UserSession();
        result.setAccountNonExpired(false);
        result.setAccountNonLocked(false);
        result.setAuthorities(new HashSet<GrantedAuthority>());
        result.setCredentialsNonExpired(false);
        result.setEnabled(true);
        result.setPassword("jimispassword");
        result.setRealName("jimiGaofei");
        result.setUserId("myId");
        result.setUsername("userName");
        return result;
    }
}
