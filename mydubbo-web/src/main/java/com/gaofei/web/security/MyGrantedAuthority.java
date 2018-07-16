package com.gaofei.web.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by GaoQingming on 2018/4/9 0009.
 */
public class MyGrantedAuthority implements GrantedAuthority{
    private String authority;

    public MyGrantedAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }

}
