package com.mapofzones.adaptor.processor;

import com.mapofzones.adaptor.constants.TimeframeConstants;
import com.mapofzones.adaptor.data.repository.CustomProcedureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Slf4j
@Service
public class Processor {

    private final CustomProcedureRepository customProcedureRepository;

    public Processor(CustomProcedureRepository customProcedureRepository) {
        this.customProcedureRepository = customProcedureRepository;
    }

    @Transactional
    public void doScript() {
        log.info("Starting...");
        Timestamp currentTimestamp = customProcedureRepository.getCurrentTimestamp();
        log.info(currentTimestamp.toString());
        String s = customProcedureRepository.updateBlockchainsHourlyStats(currentTimestamp, TimeframeConstants.DAY);
        log.info(s);
        log.info("Finished!");
        log.info("---------------");
    }
}