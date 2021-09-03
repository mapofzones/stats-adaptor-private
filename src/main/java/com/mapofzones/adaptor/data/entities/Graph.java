package com.mapofzones.adaptor.data.entities;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@IdClass(GraphKey.class)
@Table(name = "zones_graphs", schema = "public")
public class Graph {
    @Id
    @Column(name = "timeframe")
    @NonNull
    private Integer timeframe;

    @Id
    @Column(name = "source")
    @NonNull
    private String sourceZone;

    @Id
    @Column(name = "target")
    @NonNull
    private String targetZone;

    @Column(name = "channels_cnt_open")
    @NonNull
    private Integer channelsCntOpen;

    @Column(name = "channels_cnt_active")
    @NonNull
    private Integer channelsCntActive;

    @Column(name = "channels_percent_active")
    @NonNull
    private Double channelsPercentActive;

    @Column(name = "is_mainnet")
    @NonNull
    private Boolean isMainnet;
}
