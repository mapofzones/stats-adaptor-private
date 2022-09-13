package com.mapofzones.adaptor.data.repository;

import com.mapofzones.adaptor.constants.QueryConstants;
import com.mapofzones.adaptor.data.entities.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

//@Repository
//public interface ProcedureCaller {
//}

// no need any return entity, no need really use channel entity, just for stub
@Repository
public interface ProcedureCallerRepository extends JpaRepository<Channel, Long> {
    @Query(value = "select CURRENT_TIMESTAMP at time zone 'utc' as timestamp", nativeQuery = true)
    Timestamp getCurrentTimestamp();

    @Procedure("update_blockchains_hourly_stats")
    String updateBlockchainsHourlyStats(@Param("request_timestamp") Timestamp requestTimestamp, @Param("period_in_hours") Integer periodInHours);


    @Query(value = "CALL update_blockchains_hourly_stats(:request_timestamp, :period_in_hours);", nativeQuery = true)
    String updateBlockchainsHourlyStats2(@Param("request_timestamp") Timestamp requestTimestamp, @Param("period_in_hours") Integer periodInHours);

}