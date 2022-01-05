package com.mapofzones.adaptor.data.repository;

import com.mapofzones.adaptor.constants.QueryConstants;
import com.mapofzones.adaptor.data.entities.FtChannel;
import com.mapofzones.adaptor.data.entities.FtChannelKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FtChannelRepository extends JpaRepository<FtChannel, FtChannelKey> {
    @Query(value = QueryConstants.GET_FT_CHANNELS_STATS, nativeQuery = true)
    List<FtChannel>   getFtChannelsStats(@Param(value = "timeframe") int timeframe);
}