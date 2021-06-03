package com.mapofzones.adaptor.data.repository;

import com.mapofzones.adaptor.constants.QueryConstants;
import com.mapofzones.adaptor.data.entities.Channel;
import com.mapofzones.adaptor.data.entities.ChannelKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, ChannelKey> {
    @Query(value = QueryConstants.GET_CHANNELS_STATS, nativeQuery = true)
    List<Channel> getChannelsStats();
}
