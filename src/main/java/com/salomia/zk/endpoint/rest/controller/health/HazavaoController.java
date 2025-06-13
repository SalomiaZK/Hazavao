package com.salomia.zk.endpoint.rest.controller.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HazavaoController {
    @GetMapping("/hazavao")
    public String hazavao() {
        return "hazavao";
    }
}
