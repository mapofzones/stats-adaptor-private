package com.mapofzones.adaptor.data.entities;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@IdClass(ChannelKey.class)
@Table(name = "channels_stats", schema = "public")
public class Channel {
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

    @Column(name = "zone_counerparty")
    @NonNull
    private String counterpartyZone;

    @Column(name = "is_opened")
    @NonNull
    private Boolean isOpened;

    @Column(name = "ibc_tx_1d")
    @NonNull
    private Integer ibcTx1d;

    @Column(name = "ibc_tx_1d_diff")
    @NonNull
    private Integer ibcTx1dDiff;

    @Column(name = "ibc_tx_1d_failed")
    @NonNull
    private Integer ibcTx1dFailed;

    @Column(name = "ibc_tx_1d_failed_diff")
    @NonNull
    private Integer ibcTx1dFailedDiff;

    @Column(name = "ibc_tx_7d")
    @NonNull
    private Integer ibcTx7d;

    @Column(name = "ibc_tx_7d_diff")
    @NonNull
    private Integer ibcTx7dDiff;

    @Column(name = "ibc_tx_7d_failed")
    @NonNull
    private Integer ibcTx7dFailed;

    @Column(name = "ibc_tx_7d_failed_diff")
    @NonNull
    private Integer ibcTx7dFailedDiff;

    @Column(name = "ibc_tx_30d")
    @NonNull
    private Integer ibcTx30d;

    @Column(name = "ibc_tx_30d_diff")
    @NonNull
    private Integer ibcTx30dDiff;

    @Column(name = "ibc_tx_30d_failed")
    @NonNull
    private Integer ibcTx30dFailed;

    @Column(name = "ibc_tx_30d_failed_diff")
    @NonNull
    private Integer ibcTx30dFailedDiff;

    @Column(name = "zone_label_url")
    private String zoneLabelUrl ;

    @Column(name = "zone_counterparty_label_url")
    private String zoneCounterpartyLabelUrl ;

    @Column(name = "zone_readable_name")
    @NonNull
    private String zoneReadableName ;

    @Column(name = "zone_counterparty_readable_name")
    @NonNull
    private String zoneCounterpartyReadableName ;

    @Column(name = "is_zone_counerparty_mainnet")
    @NonNull
    private Boolean isZoneCounerpartyMainnet ;

    @Column(name = "zone_label_url2")
    private String zoneLabelUrl2 ;

    @Column(name = "zone_counterparty_label_url2")
    private String zoneCounterpartyLabelUrl2 ;
}
