package com.mapofzones.adaptor.data.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomProcedureRepository {

    private final JdbcTemplate jdbcTemplate;

    public CustomProcedureRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void updateBlockchainsHourlyStats() {
        jdbcTemplate.execute("CALL update_blockchains_hourly_stats(now()::timestamp without time zone, 720);");
    }
}
