package com.gaofei.web.service;

import com.gaofei.dto.UserSession;
import com.gaofei.web.security.MyGrantedAuthority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by GaoQingming on 2018/7/16 0016.
 */
public class UserDetailsServiceProxy implements UserDetailsService {
    //@Autowired
    //private UserDetailsService userDetailsService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserSession result = new UserSession();
        result.setAccountNonExpired(true);                     //Reason: User account has expired
        result.setAccountNonLocked(true);                      //是否锁定了，false别人不能再登录了，true别人可以。
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new MyGrantedAuthority("ROLE_USER"));
        authorities.add(new MyGrantedAuthority("ROLE_ADMIN"));
        result.setAuthorities(authorities);
        result.setCredentialsNonExpired(true);                  //false代表认证已经过期，true代表可以登录
        result.setEnabled(true);

        //我试验过，如果把这里的密码改成错误的，报错：Reason: Bad credentials
        //result.setPassword("wrongPasswordTest");
        //说明这里是先设置密码，然后才交由security判断是否是正确密码的。
        result.setPassword("$2a$10$ddEWZUl8aU0GdZPPpy7wbu82dvEw/pBpbRvDQRqA41y6mK1CoH00m");//jimispassword
        result.setRealName("jimiGaofei");
        result.setUserId("myId");
        result.setUsername("userName");                    //security认为的userName
        return result;
    }

    //public UserDetailsService getUserDetailsService() {
    //    return userDetailsService;
    //}
    //
    //public void setUserDetailsService(UserDetailsService userDetailsService) {
    //    this.userDetailsService = userDetailsService;
    //}
}
