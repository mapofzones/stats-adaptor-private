package com.mapofzones.adaptor.data.entities;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.math.BigInteger;

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

    @Column(name = "ibc_transfers")
    private Integer ibcTransfers;

    @Column(name = "ibc_transfers_pending")
    private Integer ibcTransfersPending;

    @Column(name = "ibc_cashflow")
    private BigInteger ibcCashflow;

    @Column(name = "ibc_cashflow_pending")
    private BigInteger ibcCashflowPending;
}
