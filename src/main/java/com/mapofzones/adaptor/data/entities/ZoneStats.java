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
}
