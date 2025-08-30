package com.rdquispe.backend.application;

import com.rdquispe.backend.domain.Control;
import com.rdquispe.backend.infraestructure.database.ControlRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rdquispe.backend.infraestructure.sftp.SftpHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

@Service
public class SftpService {

    @Value("${sftp.folder}")
    private String folder;

    private final SftpHandler sftpHandler;
    private final ControlRepository controlRepository;

    public SftpService(SftpHandler sftpHandler, ControlRepository controlRepository) {
        this.sftpHandler = sftpHandler;
        this.controlRepository = controlRepository;
    }

    public List<String> listNames() {
        return sftpHandler.ls(folder);
    }

    public boolean upload() {
        String randomUuid = RandomStringUtils.randomAlphanumeric(9).toUpperCase(Locale.ROOT);
        String uniqueName = "YUN0_" + randomUuid + ".txt";
        String filePath = folder + "/" + uniqueName;

        if (controlRepository.existsById(uniqueName)) {
            return false;
        }

        if (sftpHandler.put(filePath)) {
            Control control = new Control();
            control.setName(uniqueName);
            control.setCreationDate(LocalDateTime.now());
            control.setChecksum(randomUuid);
            control.setType("online");
            controlRepository.save(control);
            return true;
        }
        return false;
    }

    public String download(String name) {
        String filePath = folder + "/" + name;
        return sftpHandler.get(filePath);
    }

    public boolean delete(String name) {
        if (!controlRepository.existsById(name)) {
            return false;
        }

        String filePath = folder + "/" + name;
        if (sftpHandler.rm(filePath)) {
            controlRepository.deleteById(name);
            return true;
        }
        return false;
    }
}
