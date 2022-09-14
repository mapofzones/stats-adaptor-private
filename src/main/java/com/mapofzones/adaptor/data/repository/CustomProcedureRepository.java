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

    public Timestamp getCurrentTimestamp() {
        return (Timestamp) entityManager
                .createNativeQuery("select CURRENT_TIMESTAMP at time zone 'utc' as timestamp;", Timestamp.class).getSingleResult();
    }

    public String updateBlockchainsHourlyStats(Timestamp requestTimestamp, Integer periodInHours) {
        return (String) entityManager
                .createNativeQuery("CALL update_blockchains_hourly_stats(?1, ?2);", String.class)
                .setParameter(1, requestTimestamp)
                .setParameter(2, periodInHours)
                .getSingleResult();
    }
}
