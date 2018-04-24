package com.gaofei.web.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by GaoQingming on 2018/4/9 0009.
 */
public class MyGrantedAuthority implements GrantedAuthority{

    @Override
    public String getAuthority() {
        return null;
    }
}
