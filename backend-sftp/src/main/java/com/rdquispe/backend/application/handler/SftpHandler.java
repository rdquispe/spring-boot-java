package com.rdquispe.backend.application.handler;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpException;

import com.rdquispe.backend.infraestructure.util.Constants;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class SftpHandler {

    private static final Logger log = LoggerFactory.getLogger(SftpHandler.class);
    private final ChannelSftp channelSftp;

    public SftpHandler(ChannelSftp channelSftp) {
        this.channelSftp = channelSftp;
    }

    public boolean put(String destinationPath) {
        return put(Constants.XML_BBVA, destinationPath);
    }

    public boolean put(String content, String destinationPath) {
        try (InputStream inputStream = new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8))) {
            channelSftp.put(inputStream, destinationPath);
            log.info("put_success: {}", destinationPath);
            return true;
        } catch (Exception e) {
            log.error("put_error: {}", destinationPath, e);
            return false;
        }
    }

    public String get(String sourcePath) {
        try (InputStream inputStream = channelSftp.get(sourcePath)) {
            return new String(inputStream.readAllBytes(), Charset.defaultCharset());
        } catch (SftpException | IOException e) {
            log.error("get_error: {}", sourcePath, e);
            return "";
        }
    }

    public boolean rm(String sourcePath) {
        try {
            channelSftp.rm(sourcePath);
            log.info("rm_success: {}", sourcePath);
            return true;
        } catch (SftpException e) {
            log.error("rm_error: {}", sourcePath, e);
            return false;
        }
    }

    public List<String> ls(String directoryPath) {
        if (Strings.isBlank(directoryPath)) {
            return List.of();
        }

        try {
            return channelSftp.ls(directoryPath).stream()
                    .filter(entry -> !entry.getAttrs().isDir())
                    .map(ChannelSftp.LsEntry::getFilename)
                    .toList();
        } catch (SftpException e) {
            log.error("ls_error: {}", directoryPath, e);
            return List.of();
        }
    }
}
