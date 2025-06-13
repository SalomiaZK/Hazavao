package com.salomia.zk.endpoint.rest.controller.health;

import com.salomia.zk.service.HazavaoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HazavaoController {
    private HazavaoService hazavaoService;

    @GetMapping("/hazavao")
    public String hazavao(@RequestParam String word) {
        return String.valueOf(hazavaoService.getChatCompletion("donne la definition du mot" + word));
    }
}
