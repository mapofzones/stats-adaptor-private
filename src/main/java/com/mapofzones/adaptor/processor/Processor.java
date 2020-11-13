package com.mapofzones.adaptor.processor;

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
        System.out.println("Hello world!");
        Header header = headerRepository.getHeaderByTimeframe(10000, 1000);
        System.out.println(header);
        System.out.println("---------------");
    }
}
