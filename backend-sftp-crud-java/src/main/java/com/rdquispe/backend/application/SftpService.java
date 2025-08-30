package com.rdquispe.backend.application;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rdquispe.backend.application.handler.SftpHandler;

import java.util.List;
import java.util.Locale;

@Service
public class SftpService {

    @Value("${sftp.folder}")
    private String folder;

    private final SftpHandler sftpHandler;

    public SftpService(SftpHandler sftpHandler) {
        this.sftpHandler = sftpHandler;
    }

    public List<String> listNames() {
        return sftpHandler.ls(folder);
    }

    public boolean upload() {
        String randomUuid = RandomStringUtils.randomAlphanumeric(9).toUpperCase(Locale.ROOT);
        String uniqueName = "YUN0_" + randomUuid + ".txt";
        String filePath = folder + "/" + uniqueName;
        return sftpHandler.put(filePath);
    }

    public String download(String name) {
        String filePath = folder + "/" + name;
        return sftpHandler.get(filePath);
    }

    public boolean delete(String name) {
        String filePath = folder + "/" + name;
        return sftpHandler.rm(filePath);
    }
}
