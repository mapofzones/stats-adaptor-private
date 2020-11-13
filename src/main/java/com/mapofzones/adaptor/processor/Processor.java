package com.mapofzones.adaptor.processor;

import com.mapofzones.adaptor.constants.TimeframeConstants;
import com.mapofzones.adaptor.data.entities.Header;
import com.mapofzones.adaptor.data.repository.HeaderRepository;
import org.springframework.stereotype.Service;

@Service
public class Processor {
    private final HeaderRepository headerRepository;

    public Processor(HeaderRepository headerRepository) {
        this.headerRepository = headerRepository;
    }

    public void doScript() {
        System.out.println("Starting...");
        Header header = headerRepository.getHeaderByTimeframe(TimeframeConstants.DAY, TimeframeConstants.DAY_STEP);
        headerRepository.save(header);
        System.out.println("header TF " + TimeframeConstants.DAY);
        header = headerRepository.getHeaderByTimeframe(TimeframeConstants.WEEK, TimeframeConstants.WEEK_STEP);
        headerRepository.save(header);
        System.out.println("header TF " + TimeframeConstants.WEEK);
        header = headerRepository.getHeaderByTimeframe(TimeframeConstants.MONTH, TimeframeConstants.MONTH_STEP);
        headerRepository.save(header);
        System.out.println("header TF " + TimeframeConstants.MONTH + "\nFinished!");
        System.out.println("---------------");
    }
}
