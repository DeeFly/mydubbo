package com.gaofei.web.security;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by GaoQingming on 2018/4/8 0008.
 */
public class MyPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence arg0) {
        return arg0.toString();
    }

    @Override
    public boolean matches(CharSequence arg0, String arg1) {
        return arg1.equals(arg0.toString());
    }

}