package com.mapofzones.adaptor.processor;

import com.mapofzones.adaptor.constants.TimeframeConstants;
import com.mapofzones.adaptor.data.entities.Graph;
import com.mapofzones.adaptor.data.entities.Header;
import com.mapofzones.adaptor.data.entities.ZoneStats;
import com.mapofzones.adaptor.data.repository.GraphRepository;
import com.mapofzones.adaptor.data.repository.HeaderRepository;
import com.mapofzones.adaptor.data.repository.ZonesStatsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Processor {
    private final HeaderRepository headerRepository;
    private final ZonesStatsRepository zonesStatsRepository;
    private final GraphRepository graphRepository;

    public Processor(HeaderRepository headerRepository, ZonesStatsRepository zonesStatsRepository, GraphRepository graphRepository) {
        this.headerRepository = headerRepository;
        this.zonesStatsRepository = zonesStatsRepository;
        this.graphRepository = graphRepository;
    }

    public void doScript() {
        System.out.println("Starting...");

        Header header = headerRepository.getHeaderByTimeframe(TimeframeConstants.DAY, TimeframeConstants.DAY_STEP);
        headerRepository.save(header);
        System.out.println("header TF " + TimeframeConstants.DAY);

        header = headerRepository.getHeaderByTimeframe(TimeframeConstants.WEEK, TimeframeConstants.WEEK_STEP);
        headerRepository.save(header);
        System.out.println("header TF " + TimeframeConstants.WEEK);

        header = headerRepository.getHeaderByTimeframe(TimeframeConstants.MONTH, TimeframeConstants.MONTH_STEP);
        headerRepository.save(header);
        System.out.println("header TF " + TimeframeConstants.MONTH);

        List<ZoneStats> zonesStats = zonesStatsRepository.getZonesStatsByTimeframe(TimeframeConstants.DAY, TimeframeConstants.DAY_STEP);
        zonesStatsRepository.saveAll(zonesStats);
        System.out.println("zones_stats TF " + TimeframeConstants.DAY);

        zonesStats = zonesStatsRepository.getZonesStatsByTimeframe(TimeframeConstants.WEEK, TimeframeConstants.WEEK_STEP);
        zonesStatsRepository.saveAll(zonesStats);
        System.out.println("zones_stats TF " + TimeframeConstants.WEEK);

        zonesStats = zonesStatsRepository.getZonesStatsByTimeframe(TimeframeConstants.MONTH, TimeframeConstants.MONTH_STEP);
        zonesStatsRepository.saveAll(zonesStats);
        System.out.println("zones_stats TF " + TimeframeConstants.MONTH);

        List<Graph> graphs = graphRepository.getGraphsByTimeframe(TimeframeConstants.DAY);
        graphRepository.saveAll(graphs);
        System.out.println("graphs TF " + TimeframeConstants.DAY);

        graphs = graphRepository.getGraphsByTimeframe(TimeframeConstants.WEEK);
        graphRepository.saveAll(graphs);
        System.out.println("graphs TF " + TimeframeConstants.WEEK);

        graphs = graphRepository.getGraphsByTimeframe(TimeframeConstants.MONTH);
        graphRepository.saveAll(graphs);
        System.out.println("graphs TF " + TimeframeConstants.MONTH);

        System.out.println("Finished!");
        System.out.println("---------------");
    }
}
