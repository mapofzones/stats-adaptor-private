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

    public void executeBlockchainCosmoshubStub() {
        jdbcTemplate.execute("" +
                "UPDATE\n" +
                "    flat.blockchains as bh1\n" +
                "SET\n" +
                "    bonded_tokens_percent = 66.4516129032258,\n" +
                "    staking_apr = 19.2608932\n" +
                "FROM\n" +
                "    flat.blockchains as bh2\n" +
                "WHERE\n" +
                "    bh2.network_id = 'cosmoshub-4'\n" +
                "    and bh1.network_id = bh2.network_id;" +
                "");
    }

    public void executeTokenCosmoshubStub() {
        jdbcTemplate.execute("" +
                "UPDATE\n" +
                "    flat.tokens as t1\n" +
                "SET\n" +
                "    market_cap = 4401823025,\n" +
                "    on_chain_supply = 309979016\n" +
                "FROM\n" +
                "    flat.tokens as t2\n" +
                "WHERE\n" +
                "    t2.blockchain = 'cosmoshub-4'\n" +
                "    and t2.denom = 'uatom'\n" +
                "    and t1.blockchain = t2.blockchain\n" +
                "    and t1.denom = t2.denom;" +
                "");
    }
}
