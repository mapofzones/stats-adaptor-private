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

    @Column(name = "zone_counterparty")
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

    @Column(name = "is_zone_counterparty_mainnet")
    @NonNull
    private Boolean isZoneCounterpartyMainnet;

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

    @Column(name = "ibc_cashflow_in_pending")
    private BigInteger ibcCashflowInPending;

    @Column(name = "ibc_cashflow_out_pending")
    private BigInteger ibcCashflowOutPending;

    @NonNull
    public String getZone() {
        return zone;
    }

    @NonNull
    public String getClientId() {
        return clientId;
    }

    @NonNull
    public String getConnectionId() {
        return connectionId;
    }

    @NonNull
    public String getChannelId() {
        return channelId;
    }

    @NonNull
    public Integer getTimeframe() {
        return timeframe;
    }

    @NonNull
    public String getCounterpartyZone() {
        return counterpartyZone;
    }

    @NonNull
    public Boolean getOpened() {
        return isOpened;
    }

    @NonNull
    public Integer getIbcTx() {
        return ibcTx;
    }

    @NonNull
    public Integer getIbcTxDiff() {
        return ibcTxDiff;
    }

    @NonNull
    public Integer getIbcTxFailed() {
        return ibcTxFailed;
    }

    @NonNull
    public Integer getIbcTxFailedDiff() {
        return ibcTxFailedDiff;
    }

    public String getZoneLabelUrl() {
        return zoneLabelUrl;
    }

    public String getZoneCounterpartyLabelUrl() {
        return zoneCounterpartyLabelUrl;
    }

    public String getZoneReadableName() {
        return zoneReadableName;
    }

    public String getZoneCounterpartyReadableName() {
        return zoneCounterpartyReadableName;
    }

    @NonNull
    public Boolean getIsZoneCounterpartyMainnet() {
        return isZoneCounterpartyMainnet;
    }

    public String getZoneLabelUrl2() {
        return zoneLabelUrl2;
    }

    public String getZoneCounterpartyLabelUrl2() {
        return zoneCounterpartyLabelUrl2;
    }

    public String getZoneCounterpartyChannelId() {
        return zoneCounterpartyChannelId;
    }

    public String getZoneWebsite() {
        return zoneWebsite;
    }

    public BigInteger getIbcCashflowIn() {
        return ibcCashflowIn;
    }

    public BigInteger getIbcCashflowInDiff() {
        return ibcCashflowInDiff;
    }

    public BigInteger getIbcCashflowOut() {
        return ibcCashflowOut;
    }

    public BigInteger getIbcCashflowOutDiff() {
        return ibcCashflowOutDiff;
    }

    public Double getIbcTxSuccessRate() {
        return ibcTxSuccessRate;
    }

    public Double getIbcTxSuccessRateDiff() {
        return ibcTxSuccessRateDiff;
    }

    @NonNull
    public Boolean getZoneCounterpartyMainnet() {
        return isZoneCounterpartyMainnet;
    }

    public BigInteger getIbcCashflowInPending() {
        return ibcCashflowInPending;
    }

    public BigInteger getIbcCashflowOutPending() {
        return ibcCashflowOutPending;
    }
}