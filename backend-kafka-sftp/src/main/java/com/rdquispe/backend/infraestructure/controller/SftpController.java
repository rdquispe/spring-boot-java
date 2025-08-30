package com.rdquispe.backend.infraestructure.controller;

import com.rdquispe.backend.application.SftpService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@RestController
@RequestMapping("/sftp")
class SftpController {

    private final SftpService sftpService;

    public SftpController(SftpService sftpService) {
        this.sftpService = sftpService;
    }

    @GetMapping(value = "/ls", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> list() {
        return ResponseEntity.ok(sftpService.listNames());
    }

    @PostMapping(value = "")
    public ResponseEntity<Void> upload() {
        return sftpService.upload() ? ResponseEntity.status(HttpStatus.CREATED).build() :
                ResponseEntity.badRequest().build();
    }

    @GetMapping(value = "", produces = APPLICATION_XML_VALUE)
    public ResponseEntity<String> download(@RequestParam String name) {
        return ResponseEntity.ok(sftpService.download(name));
    }

    @DeleteMapping(value = "")
    public ResponseEntity<Void> delete(@RequestParam String name) {
        return sftpService.delete(name) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}

