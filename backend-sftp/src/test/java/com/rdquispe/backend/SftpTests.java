package com.rdquispe.backend;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rdquispe.backend.application.handler.SftpHandler;

@SpringBootTest
class SftpTests {

    @Autowired
    private SftpHandler sftpHandler;

    @RepeatedTest(100)
    void sftpBBVA(RepetitionInfo repetitionInfo) {
        int currentRepetition = repetitionInfo.getCurrentRepetition();
        String remotePath = String.format("/out/BBVA_000%d.txt", currentRepetition);

        sftpHandler.put(remotePath);
    }
}
