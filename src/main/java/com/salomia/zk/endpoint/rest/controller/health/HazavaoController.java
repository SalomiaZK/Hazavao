package com.salomia.zk.endpoint.rest.controller.health;

import com.salomia.zk.service.HazavaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class HazavaoController {
    @Autowired
    private HazavaoService hazavaoService;

    @GetMapping("/hazavao")
    public Mono <String>  hazavao(@RequestParam String word) {
        return hazavaoService.getChatCompletion("donne la definition du mot " + word);
    }
}
