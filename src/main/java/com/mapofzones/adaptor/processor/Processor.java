package com.mapofzones.adaptor.processor;

import com.mapofzones.adaptor.data.repository.CustomProcedureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class Processor {

    private final CustomProcedureRepository customProcedureRepository;

    public Processor(CustomProcedureRepository customProcedureRepository) {
        this.customProcedureRepository = customProcedureRepository;
    }

    @Transactional
    public void updateFlatTables() {
        System.out.println("Starting running update flat tables");
        customProcedureRepository.updateFlatTablesStats();
        customProcedureRepository.executeBlockchainCosmoshubStub();
        customProcedureRepository.executeTokenCosmoshubStub();
        System.out.println("Finished updating flat tables!");
        System.out.println("---------------");
    }

    @Transactional
    public void updateBlockchainStatsFromIbc() {
        System.out.println("Starting running update blockchain stats from ibc");
        customProcedureRepository.updateBlockchainStatsFromIbc();
        System.out.println("Finished updating blockchain stats from ibc!");
        System.out.println("---------------");
    }

    @Transactional
    public void updateAlltimeIbcStats() {
        System.out.println("Starting running update alltime ibc stats");
        customProcedureRepository.updateAlltimeIbcStats();
        System.out.println("Finished updating alltime blockchain stats from ibc!");
        System.out.println("---------------");
    }
}