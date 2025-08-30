package com.rdquispe.backend.controller;

import com.rdquispe.backend.application.SftpService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sftp")
class SftpController {

    private final SftpService sftpService;

    public SftpController(SftpService sftpService) {
        this.sftpService = sftpService;
    }

    @GetMapping(value = "/names", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> names() {
        return ResponseEntity.ok(sftpService.listNames());
    }

    @PostMapping("/upload")
    public ResponseEntity<?> upload() {
        sftpService.upload();
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/download", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> download(@RequestParam String name) {
        return ResponseEntity.ok(sftpService.download(name));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam String name) {
        boolean deleted = sftpService.delete(name);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

