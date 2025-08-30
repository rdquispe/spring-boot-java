package com.rdquispe.backend.infraestructure.config;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class SftpConfig {

    @Value("${sftp.username}")
    private String username;

    @Value("${sftp.password}")
    private String password;

    @Value("${sftp.host}")
    private String host;

    @Value("${sftp.port}")
    private int port;

    @Bean
    public ChannelSftp channelSftp() throws JSchException {
        JSch jsch = new JSch();
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");

        Session session = jsch.getSession(username, host, port);
        session.setConfig(config);
        session.setPassword(password);
        session.connect();

        ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
        channelSftp.connect();

        return channelSftp;
    }
}
