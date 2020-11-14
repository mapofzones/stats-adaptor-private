package com.mapofzones.adaptor.data.entities;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "headers", schema = "public")
public class Header {
    @Id
    @Column(name = "timeframe", unique = true)
    @NonNull
    private Integer timeframe;

    @Column(name = "zones_cnt_all")
    @NonNull
    private Integer zonesCountAll;

    @Column(name = "channels_cnt_all")
    @NonNull
    private Integer channelsCountAll;

    @Column(name = "zones_cnt_period")
    @NonNull
    private Integer zonesCountPeriod;

    @Column(name = "channels_cnt_period")
    @NonNull
    private Integer channelsCountPeriod;

    @Column(name = "chart")
    @NonNull
    private String chart;

    @Column(name = "top_zone_pair")
    @NonNull
    private String topZonePair;
}
