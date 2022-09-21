package com.mapofzones.adaptor.data.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomProcedureRepository {

    private final JdbcTemplate jdbcTemplate;

    public CustomProcedureRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void updateFlatTablesStats() {
        jdbcTemplate.execute("CALL public.update_flat_tables_calcs(now()::timestamp without time zone);");
    }
}
