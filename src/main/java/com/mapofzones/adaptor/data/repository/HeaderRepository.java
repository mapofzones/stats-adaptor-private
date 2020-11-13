package com.mapofzones.adaptor.data.repository;

import com.mapofzones.adaptor.data.entities.Header;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HeaderRepository extends JpaRepository<Header, Integer> {
    @Query(value = "select \n" +
            "    :timeframe as \"timeframe\",\n" +
            "    stats.zones_cnt_all,\n" +
            "    stats.channels_cnt_all,\n" +
            "    stats.zones_cnt_period,\n" +
            "    stats.channels_cnt_period,\n" +
            "    stats.chart,\n" +
            "    stats.top_zone_pair\n" +
            "from get_total_stats(:timeframe, :chart_step) stats",
            nativeQuery = true)
    Header getHeaderByTimeframe(@Param(value = "timeframe") int id, @Param(value = "chart_step") int chartStep);
}
