package com.mapofzones.adaptor.data.repository;

import com.mapofzones.adaptor.data.entities.FtChannelGroup;
import com.mapofzones.adaptor.data.entities.FtChannelGroupKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FtChannelGroupsRepository extends JpaRepository<FtChannelGroup, FtChannelGroupKey> {
}
