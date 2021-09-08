package com.mapofzones.adaptor.data.repository;

import com.mapofzones.adaptor.constants.QueryConstants;
import com.mapofzones.adaptor.data.entities.Header;
import com.mapofzones.adaptor.data.entities.HeaderKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HeaderRepository extends JpaRepository<Header, HeaderKey> {
    @Query(value = QueryConstants.GET_HEADER_BY_TIMEFRAME, nativeQuery = true)
    Header getHeaderByTimeframe(
            @Param(value = "timeframe") int timeframe,
            @Param(value = "chart_step") int chartStep,
            @Param(value = "is_mainnet_only") boolean isMainnetOnly
    );
}
