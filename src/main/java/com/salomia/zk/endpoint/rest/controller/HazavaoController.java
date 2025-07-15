package com.salomia.zk.endpoint.rest.controller;

import com.salomia.zk.service.HazavaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class HazavaoController {
    @Autowired
    private HazavaoService hazavaoService;

    @GetMapping("/hazavao")
    public Mono<String> hazavao(@RequestParam String word) {

        return hazavaoService.getChatCompletion("donne la definition du mot" + word);
    }


    @GetMapping("/add")
    public  long addition (@RequestParam long a, @RequestParam long b){
        if(a < 0 || b < 0){
            log.warn("negative numbers not allowed");
        }
        else if(a +b < 0){
            log.error("zero numbers not allowed");
        }
        return a+b;
    }
}
