package com.mapofzones.adaptor.processor;

import com.mapofzones.adaptor.constants.TimeframeConstants;
import com.mapofzones.adaptor.data.entities.*;
import com.mapofzones.adaptor.data.repository.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Processor {
    private final HeaderRepository headerRepository;
    private final ZonesStatsRepository zonesStatsRepository;
    private final GraphRepository graphRepository;
    private final ChannelRepository channelRepository;
    private final FtChannelRepository ftChannelRepository;

    public Processor(HeaderRepository headerRepository, ZonesStatsRepository zonesStatsRepository,
                     GraphRepository graphRepository, ChannelRepository channelRepository, FtChannelRepository ftChannelRepository) {
        this.headerRepository = headerRepository;
        this.zonesStatsRepository = zonesStatsRepository;
        this.graphRepository = graphRepository;
        this.channelRepository = channelRepository;
        this.ftChannelRepository = ftChannelRepository;
    }

    public void doScript() {
        System.out.println("Starting...");

        List<Header> headers = new ArrayList<>();
        headers.add(headerRepository.getHeaderByTimeframe(TimeframeConstants.DAY, TimeframeConstants.DAY_STEP, true));
        headers.add(headerRepository.getHeaderByTimeframe(TimeframeConstants.WEEK, TimeframeConstants.WEEK_STEP, true));
        headers.add(headerRepository.getHeaderByTimeframe(TimeframeConstants.MONTH, TimeframeConstants.MONTH_STEP, true));
        headers.add(headerRepository.getHeaderByTimeframe(TimeframeConstants.DAY, TimeframeConstants.DAY_STEP, false));
        headers.add(headerRepository.getHeaderByTimeframe(TimeframeConstants.WEEK, TimeframeConstants.WEEK_STEP, false));
        headers.add(headerRepository.getHeaderByTimeframe(TimeframeConstants.MONTH, TimeframeConstants.MONTH_STEP, false));
        System.out.println("ready to save headers");
        headerRepository.saveAll(headers);
        System.out.println("Header adaptor finished!");

        List<ZoneStats> zonesStats = zonesStatsRepository.getZonesStatsByTimeframe(TimeframeConstants.DAY, TimeframeConstants.DAY_STEP);
        zonesStats.addAll(zonesStatsRepository.getZonesStatsByTimeframe(TimeframeConstants.WEEK, TimeframeConstants.WEEK_STEP));
        zonesStats.addAll(zonesStatsRepository.getZonesStatsByTimeframe(TimeframeConstants.MONTH, TimeframeConstants.MONTH_STEP));
        System.out.println("ready to save zones_stats");
        zonesStatsRepository.saveAll(zonesStats);
        System.out.println("zones_stats adaptor finished!");

        List<Graph> graphs = graphRepository.getGraphsByTimeframe(TimeframeConstants.DAY);
        graphs.addAll(graphRepository.getGraphsByTimeframe(TimeframeConstants.WEEK));
        graphs.addAll(graphRepository.getGraphsByTimeframe(TimeframeConstants.MONTH));
        System.out.println("ready to save graphs");
        graphRepository.saveAll(graphs);
        System.out.println("graphs adaptor finished!");

        List<Channel> channels = channelRepository.getChannelsStats();
        System.out.println("ready to save channels");
        channelRepository.saveAll(channels);
        System.out.println("channels adaptor finished!");

        List<FtChannel> ftChannels = ftChannelRepository.getFtChannelsStats(TimeframeConstants.DAY_STEP);
        ftChannels.addAll(ftChannelRepository.getFtChannelsStats(TimeframeConstants.WEEK_STEP));
        ftChannels.addAll(ftChannelRepository.getFtChannelsStats(TimeframeConstants.MONTH_STEP));
        System.out.println("ready to save ft channels");
        ftChannelRepository.saveAll(ftChannels);
        System.out.println("ft channels adaptor finished!");

        System.out.println("Finished!");
        System.out.println("---------------");
    }
}
