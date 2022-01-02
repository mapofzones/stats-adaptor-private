package com.mapofzones.adaptor.data.entities;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@IdClass(FtChannelKey.class)
@Table(name = "ft_channels_stats", schema = "public")
public class FtChannel {
    @Id
    @Column(name = "zone")
    @NonNull
    private String zone;

    @Id
    @Column(name = "client_id")
    @NonNull
    private String clientId;

    @Id
    @Column(name = "connection_id")
    @NonNull
    private String connectionId;

    @Id
    @Column(name = "channel_id")
    @NonNull
    private String channelId;

    @Id
    @Column(name = "timeframe")
    @NonNull
    private Integer timeframe;

    @Column(name = "zone_counerparty")
    @NonNull
    private String counterpartyZone;

    @Column(name = "is_opened")
    @NonNull
    private Boolean isOpened;

    @Column(name = "ibc_tx")
    @NonNull
    private Integer ibcTx;

    @Column(name = "ibc_tx_diff")
    @NonNull
    private Integer ibcTxDiff;

    @Column(name = "ibc_tx_failed")
    @NonNull
    private Integer ibcTxFailed;

    @Column(name = "ibc_tx_failed_diff")
    @NonNull
    private Integer ibcTxFailedDiff;

    @Column(name = "zone_label_url")
    private String zoneLabelUrl;

    @Column(name = "zone_counterparty_label_url")
    private String zoneCounterpartyLabelUrl;

    @Column(name = "zone_readable_name")
    private String zoneReadableName;

    @Column(name = "zone_counterparty_readable_name")
    private String zoneCounterpartyReadableName;

    @Column(name = "is_zone_counerparty_mainnet")
    @NonNull
    private Boolean isZoneCounerpartyMainnet;

    @Column(name = "zone_label_url2")
    private String zoneLabelUrl2;

    @Column(name = "zone_counterparty_label_url2")
    private String zoneCounterpartyLabelUrl2;

    @Column(name = "zone_counterparty_channel_id")
    private String zoneCounterpartyChannelId;

    @Column(name = "zone_website")
    private String zoneWebsite;

    @Column(name = "ibc_cashflow_in")
    private BigInteger ibcCashflowIn;

    @Column(name = "ibc_cashflow_in_diff")
    private BigInteger ibcCashflowInDiff;

    @Column(name = "ibc_cashflow_out")
    private BigInteger ibcCashflowOut;

    @Column(name = "ibc_cashflow_out_diff")
    private BigInteger ibcCashflowOutDiff;

    @Column(name = "ibc_tx_success_rate")
    private Double ibcTxSuccessRate;

    @Column(name = "ibc_tx_success_rate_diff")
    private Double ibcTxSuccessRateDiff;
}