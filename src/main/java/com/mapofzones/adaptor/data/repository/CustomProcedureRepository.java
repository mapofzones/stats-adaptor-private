package com.mapofzones.adaptor.data.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.sql.Timestamp;

@Repository
public class CustomProcedureRepository {

    private final EntityManager entityManager;

    public CustomProcedureRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void updateBlockchainsHourlyStats() {
        Timestamp timestamp = (Timestamp) entityManager.createNativeQuery("SELECT now();").getSingleResult();

        entityManager
                .createNativeQuery("CALL update_blockchains_hourly_stats(?1, ?2);")
                .setParameter(1, timestamp)
                .setParameter(2, 720)
                .getSingleResult();
    }
}
