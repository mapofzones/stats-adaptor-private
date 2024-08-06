package com.mapofzones.adaptor.scheduler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import com.mapofzones.adaptor.processor.Processor;

@Configuration
@EnableScheduling
public class GetDataScheduler implements SchedulingConfigurer {

    private final Processor processor;

    @Value("${command-to-run:NOTSET}")
    private String commandToRun;

    @Value("${commands.update-flat-tables.sync-time}")
    private String updateFlatTablesSyncTime;

    @Value("${commands.update_blockchain_stats_from_ibc.sync-time}")
    private String updateBlockchainStatsSyncTime;

    @Value("${commands.update_all_time_ibc_stats.sync-time}")
    private String updateAllTimeIbcStats;

    public GetDataScheduler(Processor processor) {
        this.processor = processor;
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        switch (commandToRun) {
            case "update-flat-tables":
                updateFlatTablesScheduler(taskRegistrar);
                break;
            case "update_blockchain_stats_from_ibc":
                updateBlockchainStatsFromIbcScheduler(taskRegistrar);
                break;
            case "update_all_time_ibc_stats":
                updateAlltimeIbcStatsScheduler(taskRegistrar);
                break;
            default:
                System.out.println("No matching command-to-run value. Make sure to set it in the configurations.");
                System.out.println("Available commands: update-flat-tables, update_blockchain_stats_from_ibc");
                System.exit(1);
        }
    }

    public void updateFlatTablesScheduler(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addFixedDelayTask(
            () -> {
                processor.updateFlatTables();
            },
            Long.parseLong(updateFlatTablesSyncTime)
        );
    }

    public void updateBlockchainStatsFromIbcScheduler(ScheduledTaskRegistrar taskRegistrar) {
        processor.updateBlockchainStatsFromIbc();
        taskRegistrar.addCronTask(
            () -> {
                processor.updateBlockchainStatsFromIbc();
            },
            this.updateBlockchainStatsSyncTime
        );
    }

    public void updateAlltimeIbcStatsScheduler(ScheduledTaskRegistrar taskRegistrar) {
        processor.updateAlltimeIbcStats();
        taskRegistrar.addCronTask(
            () -> {
                processor.updateAlltimeIbcStats();
            },
            this.updateAllTimeIbcStats
        );
    }
}