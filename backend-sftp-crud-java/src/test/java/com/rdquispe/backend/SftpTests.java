package com.rdquispe.backend;

import com.rdquispe.backend.application.handler.SftpHandler;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SftpTests {

    @Autowired
    private SftpHandler sftpHandler;

    @RepeatedTest(100)
    void sftpBBVA(RepetitionInfo repetitionInfo) {
        int currentRepetition = repetitionInfo.getCurrentRepetition();
        String destinationPath = String.format("/out/YUN0%d.txt", currentRepetition);

        assertTrue(sftpHandler.put(destinationPath));
    }
}
