package com.rdquispe.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"${api.prefix}", ""})
public class PocController {

    @GetMapping("/process")
    public ResponseEntity<?> process() {
        return ResponseEntity.ok("ok");
    }
}
