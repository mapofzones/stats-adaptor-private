package com.mapofzones.adaptor.processor;

import com.mapofzones.adaptor.constants.TimeframeConstants;
import com.mapofzones.adaptor.data.entities.*;
import com.mapofzones.adaptor.data.repository.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Processor {
    private final HeaderRepository headerRepository;
    private final ZonesStatsRepository zonesStatsRepository;
    private final GraphRepository graphRepository;
    private final ChannelRepository channelRepository;
    private final FtChannelRepository ftChannelRepository;
    private final FtChannelGroupsRepository ftChannelGroupsRepository;
    private final ZoneStatusRepository zoneStatusRepository;

    public Processor(HeaderRepository headerRepository, ZonesStatsRepository zonesStatsRepository, GraphRepository graphRepository,
                     ChannelRepository channelRepository, FtChannelRepository ftChannelRepository, FtChannelGroupsRepository ftChannelGroupsRepository,
                     ZoneStatusRepository zoneStatusRepository) {
        this.headerRepository = headerRepository;
        this.zonesStatsRepository = zonesStatsRepository;
        this.graphRepository = graphRepository;
        this.channelRepository = channelRepository;
        this.ftChannelRepository = ftChannelRepository;
        this.ftChannelGroupsRepository = ftChannelGroupsRepository;
        this.zoneStatusRepository = zoneStatusRepository;
    }

    public void doScript() {
        System.out.println("Starting...");

        System.out.println("ready to get headers");
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

        System.out.println("ready to get zones_stats");
        List<ZoneStats> zonesStats = zonesStatsRepository.getZonesStatsByTimeframe(TimeframeConstants.DAY, TimeframeConstants.DAY_STEP, false);
        zonesStats.addAll(zonesStatsRepository.getZonesStatsByTimeframe(TimeframeConstants.WEEK, TimeframeConstants.WEEK_STEP, false));
        zonesStats.addAll(zonesStatsRepository.getZonesStatsByTimeframe(TimeframeConstants.MONTH, TimeframeConstants.MONTH_STEP, false));
        System.out.println("ready to save zones_stats");
        zonesStatsRepository.saveAll(zonesStats);
        System.out.println("zones_stats adaptor finished!");

        System.out.println("ready to get graphs");
        List<Graph> graphs = graphRepository.getGraphsByTimeframe(TimeframeConstants.DAY);
        graphs.addAll(graphRepository.getGraphsByTimeframe(TimeframeConstants.WEEK));
        graphs.addAll(graphRepository.getGraphsByTimeframe(TimeframeConstants.MONTH));
        System.out.println("ready to save graphs");
        graphRepository.saveAll(graphs);
        System.out.println("graphs adaptor finished!");

        System.out.println("ready to get channels");
        List<Channel> channels = channelRepository.getChannelsStats();
        System.out.println("ready to save channels");
        channelRepository.saveAll(channels);
        System.out.println("channels adaptor finished!");

        System.out.println("ready to get ft channels");
        List<FtChannel> ftChannels = ftChannelRepository.getFtChannelsStats(TimeframeConstants.DAY, TimeframeConstants.DAY_STEP, false);
        ftChannels.addAll(ftChannelRepository.getFtChannelsStats(TimeframeConstants.WEEK, TimeframeConstants.WEEK_STEP, false));
        ftChannels.addAll(ftChannelRepository.getFtChannelsStats(TimeframeConstants.MONTH, TimeframeConstants.MONTH_STEP, false));
        System.out.println("ready to save ft channels");
        ftChannelRepository.saveAll(ftChannels);
        System.out.println("ft channels adaptor finished!");

        System.out.println("ready to get ft channels groups");
        List<ZoneStatus> zoneStatusesList = zoneStatusRepository.getZoneStatuses();
        Map<String, ZoneStatus> zoneStatuses = new HashMap<>();
        for (ZoneStatus zoneStatus: zoneStatusesList) {
            zoneStatuses.put(zoneStatus.getZone(), zoneStatus);
        }
        List<FtChannelGroup> ftChannelGroups = getFtChannelGroups(ftChannels, zoneStatuses);
        System.out.println("ready to save ft channels groups");
        ftChannelGroupsRepository.saveAll(ftChannelGroups);
        System.out.println("ft channels groups adaptor finished!");

        System.out.println("Finished!");
        System.out.println("---------------");
    }

    private List<FtChannelGroup> getFtChannelGroups(List<FtChannel> ftChannels, Map<String, ZoneStatus> zoneStatuses){
        List<FtChannelGroup> result = new ArrayList<>();
        HashMap<String, HashMap<Integer, HashMap<String, FtChannelGroup>>> channelGroupedGroups = new HashMap<>();
        for (FtChannel ftChannel: ftChannels) {
            String zone = ftChannel.getZone();
            String zoneCounterparty = ftChannel.getCounterpartyZone();
            Integer timeframe = ftChannel.getTimeframe();
            if (!channelGroupedGroups.containsKey(zone)) {
                FtChannelGroup ftChannelGroup = createChannelGroup(zoneStatuses, ftChannel, zone);
                HashMap<String, FtChannelGroup> hashGroup = new HashMap<>() {{ put(zoneCounterparty, ftChannelGroup);}};
                HashMap<Integer, HashMap<String, FtChannelGroup>> hashTimeframe = new HashMap<>() {{ put(timeframe, hashGroup);}};
                channelGroupedGroups.put(zone, hashTimeframe);
            } else {
                if (!channelGroupedGroups.get(zone).containsKey(timeframe)) {
                    FtChannelGroup ftChannelGroup = createChannelGroup(zoneStatuses, ftChannel, zone);
                    HashMap<String, FtChannelGroup> hashGroup = new HashMap<>() {{ put(zoneCounterparty, ftChannelGroup);}};
                    channelGroupedGroups.get(zone).put(timeframe, hashGroup);
                } else {
                    if (!channelGroupedGroups.get(zone).get(timeframe).containsKey(zoneCounterparty)) {
                        FtChannelGroup ftChannelGroup = createChannelGroup(zoneStatuses, ftChannel, zone);
                        channelGroupedGroups.get(zone).get(timeframe).put(zoneCounterparty, ftChannelGroup);
                    } else {
                        FtChannelGroup ftChannelGroup = channelGroupedGroups.get(zone).get(timeframe).get(zoneCounterparty);
                        ftChannelGroup.setIbcCashflowIn(ftChannelGroup.getIbcCashflowIn().add(ftChannel.getIbcCashflowIn()));
                        ftChannelGroup.setIbcCashflowInDiff(ftChannelGroup.getIbcCashflowInDiff().add(ftChannel.getIbcCashflowInDiff()));
                        ftChannelGroup.setIbcCashflowOut(ftChannelGroup.getIbcCashflowOut().add(ftChannel.getIbcCashflowOut()));
                        ftChannelGroup.setIbcCashflowOutDiff(ftChannelGroup.getIbcCashflowOutDiff().add(ftChannel.getIbcCashflowOutDiff()));
                        ftChannelGroup.setIbcTx(ftChannelGroup.getIbcTx() + ftChannel.getIbcTx());
                        ftChannelGroup.setIbcTxDiff(ftChannelGroup.getIbcTxDiff() + ftChannel.getIbcTxDiff());
                        ftChannelGroup.setIbcTxFailed(ftChannelGroup.getIbcTxFailed() + ftChannel.getIbcTxFailed());
                        ftChannelGroup.setIbcTxFailedDiff(ftChannelGroup.getIbcTxFailedDiff() + ftChannel.getIbcTxFailedDiff());
                        ftChannelGroup.setIbcCashflowInPending(ftChannelGroup.getIbcCashflowInPending().add(ftChannel.getIbcCashflowInPending()));
                        ftChannelGroup.setIbcCashflowOutPending(ftChannelGroup.getIbcCashflowOutPending().add(ftChannel.getIbcCashflowOutPending()));

                        double divider = Math.max(ftChannelGroup.getIbcTx() + ftChannelGroup.getIbcTxFailed(), 1);
                        ftChannelGroup.setIbcTxSuccessRate(100.0 * (double)ftChannelGroup.getIbcTx() / divider);

                        double diffDivider = Math.max(
                                ftChannelGroup.getIbcTx() - ftChannelGroup.getIbcTxDiff() + ftChannelGroup.getIbcTxFailed() - ftChannelGroup.getIbcTxFailedDiff(),
                                1
                        );
                        ftChannelGroup.setIbcTxSuccessRateDiff(
                                ftChannelGroup.getIbcTxSuccessRate() -
                                        (100.0 * (double)(ftChannelGroup.getIbcTx() - ftChannelGroup.getIbcTxDiff()) / diffDivider));
                        ftChannelGroup.setIbcTxPending(
                                (ftChannelGroup.getIbcTxPending() > 0 ? ftChannelGroup.getIbcTxPending() : 0) +
                                ftChannel.getIbcTxPending()
                        );
                    }
                }
            }
        }

        for (HashMap<Integer, HashMap<String, FtChannelGroup>> channelGroups: channelGroupedGroups.values()) {
            for (HashMap<String, FtChannelGroup> linkedGroups : channelGroups.values()) {
                result.addAll(linkedGroups.values());
            }
        }

        return result;
    }

    private FtChannelGroup createChannelGroup(Map<String, ZoneStatus> zoneStatuses, FtChannel ftChannel, String zone) {
        return new FtChannelGroup(
                ftChannel.getZone(),
                ftChannel.getTimeframe(),
                ftChannel.getCounterpartyZone(),
                ftChannel.getZoneLabelUrl(),
                ftChannel.getZoneCounterpartyLabelUrl(),
                ftChannel.getIbcCashflowIn(),
                ftChannel.getIbcCashflowInDiff(),
                ftChannel.getIbcCashflowOut(),
                ftChannel.getIbcCashflowOutDiff(),
                ftChannel.getIbcTxSuccessRate(),
                ftChannel.getIbcTxSuccessRateDiff(),
                ftChannel.getIbcTx(),
                ftChannel.getIbcTxDiff(),
                ftChannel.getIbcTxFailed(),
                ftChannel.getIbcTxFailedDiff(),
                zoneStatuses.get(zone).getZoneUpToDate(),
                zoneStatuses.get(ftChannel.getCounterpartyZone()).getZoneUpToDate(),
                ftChannel.getIsZoneCounterpartyMainnet(),
                ftChannel.getZoneReadableName(),
                ftChannel.getZoneCounterpartyReadableName(),
                ftChannel.getIbcCashflowInPending(),
                ftChannel.getIbcCashflowOutPending(),
                ftChannel.getIbcTxPending()
        );
    }
}
