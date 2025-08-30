package com.rdquispe.backend.infraestructure.controller;

import com.rdquispe.backend.application.KafkaProducerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private final KafkaProducerService producerService;

    public KafkaController(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam("message") String message) {
        String payload =  """
            { "status": "ok", "message": "%s" }
            """.formatted(message);

        producerService.sendMessage(payload);
        return payload;
    }
}
