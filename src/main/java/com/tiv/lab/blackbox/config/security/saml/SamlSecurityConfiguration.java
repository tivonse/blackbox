package com.tiv.lab.blackbox.config.security.saml;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.saml.provider.SamlServerConfiguration;
import org.springframework.security.saml.provider.service.config.SamlServiceProviderServerBeanConfiguration;

//@Configuration
//public class SamlSecurityConfiguration extends SamlServiceProviderServerBeanConfiguration {
//
//    private final SamlAppConfig samlAppConfig;
//
//    public SamlSecurityConfiguration(SamlAppConfig samlAppConfig){
//        this.samlAppConfig = samlAppConfig;
//    }
//
//    @Override
//    protected SamlServerConfiguration getDefaultHostSamlServerConfiguration() {
//        return samlAppConfig;
//    }
//}