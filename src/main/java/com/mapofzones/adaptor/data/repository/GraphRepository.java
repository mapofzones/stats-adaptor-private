package com.mapofzones.adaptor.data.repository;

import com.mapofzones.adaptor.constants.QueryConstants;
import com.mapofzones.adaptor.data.entities.Graph;
import com.mapofzones.adaptor.data.entities.GraphKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GraphRepository extends JpaRepository<Graph, GraphKey> {
    @Query(value = QueryConstants.GET_GRAPHS_BY_TIMEFRAME, nativeQuery = true)
    List<Graph> getGraphsByTimeframe(@Param(value = "timeframe") int timeframe);
}
