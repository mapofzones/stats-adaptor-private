package com.mapofzones.adaptor.data.repository;

import com.mapofzones.adaptor.constants.QueryConstants;
import com.mapofzones.adaptor.data.entities.ZoneStats;
import com.mapofzones.adaptor.data.entities.ZoneStatsKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZonesStatsRepository extends JpaRepository<ZoneStats, ZoneStatsKey> {
    @Query(value = QueryConstants.GET_ZONES_STATS_BY_TIMEFRAME, nativeQuery = true)
    List<ZoneStats> getZonesStatsByTimeframe(
            @Param(value = "timeframe") int timeframe,
            @Param(value = "chart_step") int chartStep,
            @Param(value = "is_mainnet_only") boolean isMainnetOnly
    );
}
