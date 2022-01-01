package com.mapofzones.adaptor.data.entities;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@IdClass(HeaderKey.class)
@Table(name = "headers", schema = "public")
public class Header {
    @Id
    @Column(name = "timeframe")
    @NonNull
    private Integer timeframe;

    @Id
    @Column(name = "is_mainnet_only")
    @NonNull
    public Boolean isMainnetOnly;

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

    @Column(name = "ibc_cashflow_period")
    @NonNull
    private BigInteger ibcCashflowPeriod;

    @Column(name = "ibc_cashflow_period_diff")
    @NonNull
    private BigInteger ibcCashflowPeriodDiff;

    @Column(name = "top_ibc_cashflow_zone_pair")
    @NonNull
    private String topIbcCashflowZonePair;
}
