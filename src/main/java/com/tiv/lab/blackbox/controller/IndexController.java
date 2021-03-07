package com.tiv.lab.blackbox.controller;

import com.tiv.lab.blackbox.model.AbstractEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IndexController {

    private final static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Value("${saml.discovery.url:/saml/sp/discovery}")
    private String samlDiscoveryUrl;

    @Value("${saml.discovery.entity-id:https://sts.windows.net/a55c55bf-3178-40ba-928b-64abab01bc03/}")
    private String samlDiscoveryEntityId;

//    private SamlProviderProvisioning<ServiceProviderService> provisioning;

    @Autowired
    private SimpleCacheManager simpleCacheManager;

//    @Cacheable("ping")
    @GetMapping(name = "/ping")
    @ResponseBody
    public ResponseEntity<String> ping() {
        return new ResponseEntity<>("Pong", HttpStatus.OK);
    }

    @RequestMapping(value = "/stub/check/{id}", method = RequestMethod.GET)
    public @ResponseBody
    AbstractEntity checkStub(@PathVariable Long id) {
        ConcurrentMapCache result = (ConcurrentMapCache) simpleCacheManager.getCache("getStubById");
        if (result != null && result.get(id) != null) {
            Cache.ValueWrapper cacheValue = result.get(id);
            if (cacheValue != null) {
                Object resultByKey = cacheValue.get();
                if (resultByKey != null) {
                    return (AbstractEntity) resultByKey;
                }
            }
        }
        return null;
    }

//    @Autowired
//    public void setSamlService(SamlProviderProvisioning<ServiceProviderService> provisioning) {
//        this.provisioning = provisioning;
//    }

//    @RequestMapping(value = {"/home"})
//    public String home(Model model) {
//
//        model.addAttribute("samlLink", "0; url='"+ samlDiscoveryUrl + "?idp="+ samlDiscoveryEntityId+"'");
//        return "saml-login";
//    }

    @RequestMapping(value = {"/"})
    public String home(){
        return "index";
    }

    @RequestMapping(value = {"/main"})
    public String main(){
        return "main";
    }

}
