package com.spring.springsercuity.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpSession;

@Slf4j
@RestController
public class WebController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/vip")
    @PreAuthorize("hasRole('ADMIN')")
    public String vip(HttpSession session){
        log.info((String)session.getAttribute("username"));
        return "web/vip";
    }

    @RequestMapping("/webflux")
    @ResponseBody
    public Mono<String> webflux(){
        return Mono.just("Hello Webflux");
    }

}
