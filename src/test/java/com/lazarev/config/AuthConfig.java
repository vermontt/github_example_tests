package com.lazarev.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:app.properties")
public interface AuthConfig extends Config {

    @Config.Key("login")
    String getLogin();

    @Config.Key("password")
    String getPassword();
}