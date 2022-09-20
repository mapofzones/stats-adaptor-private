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

    //public boolean updateBlockchainsHourlyStats(Timestamp requestTimestamp, Integer periodInHours) {
//    public boolean updateBlockchainsHourlyStats() {
//        return entityManager
//                .createNamedStoredProcedureQuery("update_blockchains_hourly_stats")
////                .setParameter("request_timestamp", requestTimestamp)
////                .setParameter("period_in_hours", periodInHours)
//                .execute();
//    }

    public void updateBlockchainsHourlyStats() {
        entityManager
            .createNativeQuery("public.update_flat_tables_calcs(now()::timestamp without time zone);")
            .executeUpdate();
    }

}
