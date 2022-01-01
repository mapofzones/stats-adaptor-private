package com.mapofzones.adaptor.data.entities;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@IdClass(ZoneStatsKey.class)
@Table(name = "zones_stats", schema = "public")
public class ZoneStats {
    @Id
    @Column(name = "timeframe")
    @NonNull
    private int timeframe;

    @Id
    @Column(name = "zone")
    @NonNull
    private String zone;

    @Column(name = "total_txs")
    @NonNull
    private Integer totalTxsCount;

    @Column(name = "total_ibc_txs")
    @NonNull
    private Integer totalIbcTxsCount;

    @Column(name = "ibc_percent")
    @NonNull
    private Double ibcPercent;

    @Column(name = "ibc_tx_out")
    @NonNull
    private Integer ibcTxOutCount;

    @Column(name = "ibc_tx_in")
    @NonNull
    private Integer ibcTxInCount;

    @Column(name = "channels_num ")
    @NonNull
    private Integer channelsCount;

    @Column(name = "chart")
    @NonNull
    private String chart;

    @Column(name = "total_txs_rating")
    @NonNull
    private Integer totalTxsRating;

    @Column(name = "total_txs_diff")
    @NonNull
    private Integer totalTxsDiff;

    @Column(name = "total_txs_rating_diff ")
    @NonNull
    private Integer totalTxsRatingDiff;

    @Column(name = "total_ibc_txs_rating")
    @NonNull
    private Integer totalIbcTxsRating;

    @Column(name = "total_ibc_txs_diff")
    @NonNull
    private Integer totalIbcTxsDiff;

    @Column(name = "total_ibc_txs_rating_diff")
    @NonNull
    private Integer totalIbcTxsRatingDiff;

    @Column(name = "ibc_tx_in_rating")
    @NonNull
    private Integer ibcTxInRating;

    @Column(name = "ibc_tx_in_diff")
    @NonNull
    private Integer ibcTxInDiff;

    @Column(name = "ibc_tx_in_rating_diff")
    @NonNull
    private Integer ibcTxInRatingDiff;

    @Column(name = "ibc_tx_out_rating")
    @NonNull
    private Integer ibcTxOutRating;

    @Column(name = "ibc_tx_out_diff")
    @NonNull
    private Integer ibcTxOutDiff;

    @Column(name = "ibc_tx_out_rating_diff")
    @NonNull
    private Integer ibcTxOutRatingDiff;

    @Column(name = "total_ibc_txs_weight")
    @NonNull
    private Double totalIbcTxsWeight;

    @Column(name = "total_txs_weight")
    @NonNull
    private Double totalTxsWeight;

    @Column(name = "ibc_tx_in_weight ")
    @NonNull
    private Double ibcTxInWeight;

    @Column(name = "ibc_tx_out_weight ")
    @NonNull
    private Double ibcTxOutWeight;

    @Column(name = "total_active_addresses_weight")
    @NonNull
    private Double totalActiveAddressesWeight;

    @Column(name = "ibc_tx_failed")
    @NonNull
    private Integer ibcTxFailed;

    @Column(name = "ibc_tx_failed_diff")
    @NonNull
    private Integer ibcTxFailedDiff;

    @Column(name = "total_active_addresses")
    @NonNull
    private Integer totalActiveAddresses;

    @Column(name = "total_active_addresses_diff")
    @NonNull
    private Integer totalActiveAddressesDiff;

    @Column(name = "total_active_addresses_rating")
    @NonNull
    private Integer totalActiveAddressesRating;

    @Column(name = "total_active_addresses_rating_diff")
    @NonNull
    private Integer totalActiveAddressesRatingDiff;

    @Column(name = "total_coin_turnover_amount")
    @NonNull
    private BigInteger totalCoinTurnoverAmount;

    @Column(name = "total_coin_turnover_amount_diff")
    @NonNull
    private BigInteger totalCoinTurnoverAmountDiff;

    @Column(name = "ibc_tx_in_failed")
    @NonNull
    private Integer ibcTxInFailed;

    @Column(name = "ibc_tx_out_failed")
    @NonNull
    private Integer ibcTxOutFailed;

    @Column(name = "zone_label_url")
    private String zoneLabelUrl;

    @Column(name = "is_zone_mainnet")
    @NonNull
    private Boolean isZoneMainnet;

    @Column(name = "is_zone_new")
    @NonNull
    private Boolean isZoneNew;

    @Column(name = "is_zone_up_to_date")
    private Boolean isZoneUpToDate;

    @Column(name = "zone_readable_name")
    @NonNull
    private String zoneReadableName;

    @Column(name = "ibc_tx_in_mainnet_rating")
    private Integer ibcTxInMainnetRating;

    @Column(name = "total_active_addresses_mainnet_weight")
    private Double totalActiveAddressesMainnetWeight;

    @Column(name = "total_active_addresses_mainnet_rating_diff")
    private Integer totalActiveAddressesMainnetRatingDiff;

    @Column(name = "total_active_addresses_mainnet_rating")
    private Integer totalActiveAddressesMainnetRating;

    @Column(name = "total_ibc_txs_mainnet_rating_diff")
    private Integer totalIbcTxsMainnetRatingDiff;

    @Column(name = "ibc_tx_out_mainnet_rating_diff")
    private Integer ibcTxOutMainnetRatingDiff;

    @Column(name = "total_txs_mainnet_rating_diff")
    private Integer totalTxsMainnetRatingDiff;

    @Column(name = "ibc_tx_in_mainnet_rating_diff")
    private Integer ibcTxInMainnetRatingDiff;

    @Column(name = "total_ibc_txs_mainnet_weight")
    private Double totalIbcTxsMainnetWeight;

    @Column(name = "total_ibc_txs_mainnet_rating")
    private Integer totalIbcTxsMainnetRating;

    @Column(name = "ibc_tx_out_mainnet_weight")
    private Double ibcTxOutMainnetWeight;

    @Column(name = "ibc_tx_out_mainnet_rating")
    private Integer ibcTxOutMainnetRating;

    @Column(name = "total_txs_mainnet_weight")
    private Double totalTxsMainnetWeight;

    @Column(name = "total_txs_mainnet_rating")
    private Integer totalTxsMainnetRating;

    @Column(name = "ibc_tx_in_mainnet_weight")
    private Double ibcTxInMainnetWeight;

    @Column(name = "zone_label_url2")
    private String zoneLabelUrl2;

    @Column(name = "ibc_cashflow")
    private String ibcCashflow;

    @Column(name = "ibc_cashflow_diff")
    private String ibcCashflowDiff;

    @Column(name = "ibc_cashflow_rating")
    private String ibcCashflowRating;

    @Column(name = "ibc_cashflow_rating_diff")
    private String ibcCashflowRatingDiff;

    @Column(name = "ibc_cashflow_weight")
    private String ibcCashflowWeight;

    @Column(name = "ibc_cashflow_mainnet_rating")
    private String ibcCashflowMainnetRating;

    @Column(name = "ibc_cashflow_mainnet_rating_diff")
    private String ibcCashflowMainnetRatingDiff;

    @Column(name = "ibc_cashflow_mainnet_weight")
    private String ibcCashflowMainnetWeight;

    @Column(name = "ibc_cashflow_in")
    private String ibcCashflowIn;

    @Column(name = "ibc_cashflow_in_percent")
    private String ibcCashflowInPercent;

    @Column(name = "ibc_cashflow_out")
    private String ibcCashflowOut;

    @Column(name = "ibc_cashflow_out_percent")
    private String ibcCashflowOutPercent;

    @Column(name = "ibc_peers")
    private String ibcPeers;

    @Column(name = "ibc_peers_mainnet")
    private String ibcPeersMainnet;

    @Column(name = "ibc_cashflow_out_diff")
    private String ibcCashflowOutDiff;

    @Column(name = "ibc_cashflow_out_rating")
    private String ibcCashflowOutRating;

    @Column(name = "ibc_cashflow_out_mainnet_rating")
    private String ibcCashflowOutMainnetRating;

    @Column(name = "ibc_cashflow_out_weight")
    private String ibcCashflowOutWeight;

    @Column(name = "ibc_cashflow_out_mainnet_weight")
    private String ibcCashflowOutMainnetWeight;

    @Column(name = "ibc_cashflow_out_rating_diff")
    private String ibcCashflowOutRatingDiff;

    @Column(name = "ibc_cashflow_out_mainnet_rating_diff")
    private String ibcCashflowOutMainnetRatingDiff;

    @Column(name = "ibc_cashflow_in_diff")
    private String ibcCashflowInDiff;

    @Column(name = "ibc_cashflow_in_rating")
    private String ibcCashflowInRating;

    @Column(name = "ibc_cashflow_in_mainnet_rating")
    private String ibcCashflowInMainnetRating;

    @Column(name = "ibc_cashflow_in_weight")
    private String ibcCashflowInWeight;

    @Column(name = "ibc_cashflow_in_mainnet_weight")
    private String ibcCashflowInMainnetWeight;

    @Column(name = "ibc_cashflow_in_rating_diff")
    private String ibcCashflowInRatingDiff;

    @Column(name = "ibc_cashflow_in_mainnet_rating_diff")
    private String ibcCashflowInMainnetRatingDiff;
}
