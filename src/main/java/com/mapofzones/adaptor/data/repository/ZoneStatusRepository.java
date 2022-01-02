package com.mapofzones.adaptor.data.repository;

import com.mapofzones.adaptor.constants.QueryConstants;
import com.mapofzones.adaptor.data.entities.ZoneStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZoneStatusRepository extends JpaRepository<ZoneStatus, String> {
    @Query(value = QueryConstants.GET_ZONES_UP_TO_DATE_STATUS, nativeQuery = true)
    List<ZoneStatus>   getZoneStatuses();
}
