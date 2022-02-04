package com.mapofzones.adaptor.data.entities;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@IdClass(FtChannelGroupKey.class)
@Table(name = "ft_channel_group_stats", schema = "public")
public class FtChannelGroup {
    @Id
    @Column(name = "zone")
    @NonNull
    private String zone;

    @Id
    @Column(name = "timeframe")
    @NonNull
    private Integer timeframe;

    @Id
    @Column(name = "zone_counterparty")
    @NonNull
    private String counterpartyZone;

    @Column(name = "zone_label_url")
    private String zoneLabelUrl;

    @Column(name = "zone_counterparty_label_url")
    private String zoneCounterpartyLabelUrl;

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

    @Column(name = "is_zone_up_to_date")
    @NonNull
    private Boolean isZoneUpToDate;

    @Column(name = "is_zone_counterparty_up_to_date")
    @NonNull
    private Boolean isZoneCounterpartyUpToDate;

    @Column(name = "is_zone_counterparty_mainnet")
    @NonNull
    private Boolean isZoneCounterpartyMainnet;

    @Column(name = "zone_readable_name")
    private String zoneReadableName;

    @Column(name = "zone_counterparty_readable_name")
    private String zoneCounterpartyReadableName;

    @Column(name = "ibc_cashflow_in_pending")
    @NonNull
    private BigInteger ibcCashflowInPending;

    @Column(name = "ibc_cashflow_out_pending")
    @NonNull
    private BigInteger ibcCashflowOutPending;

    public FtChannelGroup() {
    }

    public FtChannelGroup(@NonNull String zone, @NonNull Integer timeframe, @NonNull String counterpartyZone,
                          String zoneLabelUrl, String zoneCounterpartyLabelUrl, BigInteger ibcCashflowIn,
                          BigInteger ibcCashflowInDiff, BigInteger ibcCashflowOut, BigInteger ibcCashflowOutDiff,
                          Double ibcTxSuccessRate, Double ibcTxSuccessRateDiff, @NonNull Integer ibcTx,
                          @NonNull Integer ibcTxDiff, @NonNull Integer ibcTxFailed, @NonNull Integer ibcTxFailedDiff,
                          @NonNull Boolean isZoneUpToDate, @NonNull Boolean isZoneCounterpartyUpToDate,
                          @NonNull Boolean isZoneCounterpartyMainnet, String zoneReadableName, String zoneCounterpartyReadableName,
                          @NonNull BigInteger ibcCashflowInPending, @NonNull BigInteger ibcCashflowOutPending) {
        this.zone = zone;
        this.timeframe = timeframe;
        this.counterpartyZone = counterpartyZone;
        this.zoneLabelUrl = zoneLabelUrl;
        this.zoneCounterpartyLabelUrl = zoneCounterpartyLabelUrl;
        this.ibcCashflowIn = ibcCashflowIn;
        this.ibcCashflowInDiff = ibcCashflowInDiff;
        this.ibcCashflowOut = ibcCashflowOut;
        this.ibcCashflowOutDiff = ibcCashflowOutDiff;
        this.ibcTxSuccessRate = ibcTxSuccessRate;
        this.ibcTxSuccessRateDiff = ibcTxSuccessRateDiff;
        this.ibcTx = ibcTx;
        this.ibcTxDiff = ibcTxDiff;
        this.ibcTxFailed = ibcTxFailed;
        this.ibcTxFailedDiff = ibcTxFailedDiff;
        this.isZoneUpToDate = isZoneUpToDate;
        this.isZoneCounterpartyUpToDate = isZoneCounterpartyUpToDate;
        this.isZoneCounterpartyMainnet = isZoneCounterpartyMainnet;
        this.zoneReadableName = zoneReadableName;
        this.zoneCounterpartyReadableName = zoneCounterpartyReadableName;
        this.ibcCashflowInPending = ibcCashflowInPending;
        this.ibcCashflowOutPending = ibcCashflowOutPending;
    }

    @NonNull
    public String getZone() {
        return zone;
    }

    public void setZone(@NonNull String zone) {
        this.zone = zone;
    }

    @NonNull
    public Integer getTimeframe() {
        return timeframe;
    }

    public void setTimeframe(@NonNull Integer timeframe) {
        this.timeframe = timeframe;
    }

    @NonNull
    public String getCounterpartyZone() {
        return counterpartyZone;
    }

    public void setCounterpartyZone(@NonNull String counterpartyZone) {
        this.counterpartyZone = counterpartyZone;
    }

    public String getZoneLabelUrl() {
        return zoneLabelUrl;
    }

    public void setZoneLabelUrl(String zoneLabelUrl) {
        this.zoneLabelUrl = zoneLabelUrl;
    }

    public String getZoneCounterpartyLabelUrl() {
        return zoneCounterpartyLabelUrl;
    }

    public void setZoneCounterpartyLabelUrl(String zoneCounterpartyLabelUrl) {
        this.zoneCounterpartyLabelUrl = zoneCounterpartyLabelUrl;
    }

    public BigInteger getIbcCashflowIn() {
        return ibcCashflowIn;
    }

    public void setIbcCashflowIn(BigInteger ibcCashflowIn) {
        this.ibcCashflowIn = ibcCashflowIn;
    }

    public BigInteger getIbcCashflowInDiff() {
        return ibcCashflowInDiff;
    }

    public void setIbcCashflowInDiff(BigInteger ibcCashflowInDiff) {
        this.ibcCashflowInDiff = ibcCashflowInDiff;
    }

    public BigInteger getIbcCashflowOut() {
        return ibcCashflowOut;
    }

    public void setIbcCashflowOut(BigInteger ibcCashflowOut) {
        this.ibcCashflowOut = ibcCashflowOut;
    }

    public BigInteger getIbcCashflowOutDiff() {
        return ibcCashflowOutDiff;
    }

    public void setIbcCashflowOutDiff(BigInteger ibcCashflowOutDiff) {
        this.ibcCashflowOutDiff = ibcCashflowOutDiff;
    }

    public Double getIbcTxSuccessRate() {
        return ibcTxSuccessRate;
    }

    public void setIbcTxSuccessRate(Double ibcTxSuccessRate) {
        this.ibcTxSuccessRate = ibcTxSuccessRate;
    }

    public Double getIbcTxSuccessRateDiff() {
        return ibcTxSuccessRateDiff;
    }

    public void setIbcTxSuccessRateDiff(Double ibcTxSuccessRateDiff) {
        this.ibcTxSuccessRateDiff = ibcTxSuccessRateDiff;
    }

    @NonNull
    public Integer getIbcTx() {
        return ibcTx;
    }

    public void setIbcTx(@NonNull Integer ibcTx) {
        this.ibcTx = ibcTx;
    }

    @NonNull
    public Integer getIbcTxDiff() {
        return ibcTxDiff;
    }

    public void setIbcTxDiff(@NonNull Integer ibcTxDiff) {
        this.ibcTxDiff = ibcTxDiff;
    }

    @NonNull
    public Integer getIbcTxFailed() {
        return ibcTxFailed;
    }

    public void setIbcTxFailed(@NonNull Integer ibcTxFailed) {
        this.ibcTxFailed = ibcTxFailed;
    }

    @NonNull
    public Integer getIbcTxFailedDiff() {
        return ibcTxFailedDiff;
    }

    public void setIbcTxFailedDiff(@NonNull Integer ibcTxFailedDiff) {
        this.ibcTxFailedDiff = ibcTxFailedDiff;
    }

    @NonNull
    public Boolean getZoneUpToDate() {
        return isZoneUpToDate;
    }

    public void setZoneUpToDate(@NonNull Boolean zoneUpToDate) {
        isZoneUpToDate = zoneUpToDate;
    }

    @NonNull
    public Boolean getZoneCounterpartyUpToDate() {
        return isZoneCounterpartyUpToDate;
    }

    public void setZoneCounterpartyUpToDate(@NonNull Boolean zoneCounterpartyUpToDate) {
        isZoneCounterpartyUpToDate = zoneCounterpartyUpToDate;
    }

    @NonNull
    public Boolean getZoneCounterpartyMainnet() {
        return isZoneCounterpartyMainnet;
    }

    public void setZoneCounterpartyMainnet(@NonNull Boolean zoneCounterpartyMainnet) {
        isZoneCounterpartyMainnet = zoneCounterpartyMainnet;
    }

    public String getZoneReadableName() {
        return zoneReadableName;
    }

    public void setZoneReadableName(String zoneReadableName) {
        this.zoneReadableName = zoneReadableName;
    }

    public String getZoneCounterpartyReadableName() {
        return zoneCounterpartyReadableName;
    }

    public void setZoneCounterpartyReadableName(String zoneCounterpartyReadableName) {
        this.zoneCounterpartyReadableName = zoneCounterpartyReadableName;
    }

    @NonNull
    public BigInteger getIbcCashflowInPending() {
        return ibcCashflowInPending;
    }

    public void setIbcCashflowInPending(@NonNull BigInteger ibcCashflowInPending) {
        this.ibcCashflowInPending = ibcCashflowInPending;
    }

    @NonNull
    public BigInteger getIbcCashflowOutPending() {
        return ibcCashflowOutPending;
    }

    public void setIbcCashflowOutPending(@NonNull BigInteger ibcCashflowOutPending) {
        this.ibcCashflowOutPending = ibcCashflowOutPending;
    }
}
