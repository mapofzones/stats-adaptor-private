package com.mapofzones.adaptor.data.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class CustomProcedureRepository {

    private final EntityManager entityManager;

    public CustomProcedureRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public String updateFlatTablesCalcs() {
        return (String) entityManager
                .createNativeQuery("public.update_flat_tables_calcs(now()::timestamp without time zone);", String.class)
                .getSingleResult();
    }
}
