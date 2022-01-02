package com.mapofzones.adaptor.constants;

public interface QueryConstants {
    String GET_CHANNELS_STATS = "" +
            "select\n" +
            "    zone,\n" +
            "    client_id,\n" +
            "    connection_id,\n" +
            "    channel_id,\n" +
            "    zone_counerparty,\n" +
            "    is_opened,\n" +
            "    ibc_tx_1d,\n" +
            "    ibc_tx_1d_diff,\n" +
            "    ibc_tx_1d_failed,\n" +
            "    ibc_tx_1d_failed_diff,\n" +
            "    ibc_tx_7d,\n" +
            "    ibc_tx_7d_diff,\n" +
            "    ibc_tx_7d_failed,\n" +
            "    ibc_tx_7d_failed_diff,\n" +
            "    ibc_tx_30d,\n" +
            "    ibc_tx_30d_diff,\n" +
            "    ibc_tx_30d_failed,\n" +
            "    ibc_tx_30d_failed_diff,\n" +
            "    zone_label_url,\n" +
            "    zone_counterparty_label_url,\n" +
            "    zone_readable_name,\n" +
            "    zone_counterparty_readable_name,\n" +
            "    is_zone_counerparty_mainnet,\n" +
            "    zone_label_url2,\n" +
            "    zone_counterparty_label_url2\n" +
            "from\n" +
            "    public.get_chanels_stats()";

    String GET_HEADER_BY_TIMEFRAME = "" +
            "select \n" +
            "    :timeframe as \"timeframe\",\n" +
            "    stats.zones_cnt_all,\n" +
            "    stats.channels_cnt_all,\n" +
            "    stats.zones_cnt_period,\n" +
            "    stats.channels_cnt_period,\n" +
            "    stats.chart,\n" +
            "    stats.top_zone_pair,\n" +
            "    stats.is_mainnet_only,\n" +
            "    stats.ibc_cashflow_period,\n" +
            "    stats.ibc_cashflow_period_diff,\n" +
            "    stats.top_ibc_cashflow_zone_pair\n" +
            "from " +
            "    get_total_stats(:timeframe, :chart_step, :is_mainnet_only) stats";

    String GET_ZONES_STATS_BY_TIMEFRAME = "" +
            "select\n" +
            "    :timeframe as timeframe,\n" +
            "    stats.zone,\n" +
            "    stats.total_txs,\n" +
            "    stats.total_ibc_txs,\n" +
            "    stats.ibc_percent,\n" +
            "    stats.ibc_tx_out,\n" +
            "    stats.ibc_tx_in,\n" +
            "    stats.channels_num,\n" +
            "    stats.chart,\n" +
            "    stats.total_txs_rating,\n" +
            "    stats.total_txs_diff,\n" +
            "    stats.total_txs_rating_diff,\n" +
            "    stats.total_ibc_txs_rating,\n" +
            "    stats.total_ibc_txs_diff,\n" +
            "    stats.total_ibc_txs_rating_diff,\n" +
            "    stats.ibc_tx_in_rating,\n" +
            "    stats.ibc_tx_in_diff,\n" +
            "    stats.ibc_tx_in_rating_diff,\n" +
            "    stats.ibc_tx_out_rating,\n" +
            "    stats.ibc_tx_out_diff,\n" +
            "    stats.ibc_tx_out_rating_diff,\n" +
            "    stats.total_ibc_txs_weight,\n" +
            "    stats.total_txs_weight,\n" +
            "    stats.ibc_tx_in_weight,\n" +
            "    stats.ibc_tx_out_weight,\n" +
            "    stats.total_active_addresses_weight,\n" +
            "    stats.ibc_tx_failed,\n" +
            "    stats.ibc_tx_failed_diff,\n" +
            "    stats.total_active_addresses,\n" +
            "    stats.total_active_addresses_diff,\n" +
            "    stats.total_active_addresses_rating,\n" +
            "    stats.total_active_addresses_rating_diff,\n" +
            "    stats.total_coin_turnover_amount,\n" +
            "    stats.total_coin_turnover_amount_diff,\n" +
            "    stats.ibc_tx_in_failed,\n" +
            "    stats.ibc_tx_out_failed,\n" +
            "    stats.zone_label_url,\n" +
            "    stats.is_zone_mainnet,\n" +
            "    stats.is_zone_new,\n" +
            "    stats.is_zone_up_to_date,\n" +
            "    stats.zone_readable_name,\n" +
            "    stats.ibc_tx_in_mainnet_rating,\n" +
            "    stats.total_active_addresses_mainnet_weight,\n" +
            "    stats.total_active_addresses_mainnet_rating_diff,\n" +
            "    stats.total_active_addresses_mainnet_rating,\n" +
            "    stats.total_ibc_txs_mainnet_rating_diff,\n" +
            "    stats.ibc_tx_out_mainnet_rating_diff,\n" +
            "    stats.total_txs_mainnet_rating_diff,\n" +
            "    stats.ibc_tx_in_mainnet_rating_diff,\n" +
            "    stats.total_ibc_txs_mainnet_weight,\n" +
            "    stats.total_ibc_txs_mainnet_rating,\n" +
            "    stats.ibc_tx_out_mainnet_weight,\n" +
            "    stats.ibc_tx_out_mainnet_rating,\n" +
            "    stats.total_txs_mainnet_weight,\n" +
            "    stats.total_txs_mainnet_rating,\n" +
            "    stats.ibc_tx_in_mainnet_weight,\n" +
            "    stats.zone_label_url2,\n" +
            "    stats.cashflow as ibc_cashflow,\n" +
            "    stats.cashflow_diff as ibc_cashflow_diff,\n" +
            "    stats.ibc_cashflow_rating,\n" +
            "    stats.ibc_cashflow_rating_diff,\n" +
            "    stats.ibc_cashflow_weight,\n" +
            "    stats.ibc_cashflow_mainnet_rating,\n" +
            "    stats.ibc_cashflow_mainnet_rating_diff,\n" +
            "    stats.ibc_cashflow_mainnet_weight,\n" +
            "    stats.cashflow_in as ibc_cashflow_in,\n" +
            "    stats.cashflow_in_percent as ibc_cashflow_in_percent,\n" +
            "    stats.cashflow_out as ibc_cashflow_out,\n" +
            "    stats.cashflow_out_percent as ibc_cashflow_out_percent,\n" +
            "    stats.ibc_peers,\n" +
            "    stats.ibc_peers_mainnet,\n" +
            "    stats.cashflow_out_diff as ibc_cashflow_out_diff,\n" +
            "    stats.ibc_cashflow_out_rating,\n" +
            "    stats.ibc_cashflow_out_mainnet_rating,\n" +
            "    stats.ibc_cashflow_out_weight,\n" +
            "    stats.ibc_cashflow_out_mainnet_weight,\n" +
            "    stats.ibc_cashflow_out_rating_diff,\n" +
            "    stats.ibc_cashflow_out_mainnet_rating_diff,\n" +
            "    stats.cashflow_in_diff as ibc_cashflow_in_diff,\n" +
            "    stats.ibc_cashflow_in_rating,\n" +
            "    stats.ibc_cashflow_in_mainnet_rating,\n" +
            "    stats.ibc_cashflow_in_weight,\n" +
            "    stats.ibc_cashflow_in_mainnet_weight,\n" +
            "    stats.ibc_cashflow_in_rating_diff,\n" +
            "    stats.ibc_cashflow_in_mainnet_rating_diff\n" +
            "from\n" +
            "    get_full_stats_for_each_zone(:timeframe, :chart_step) stats";

    String GET_GRAPHS_BY_TIMEFRAME = "" +
            "select\n" +
            "    :timeframe as timeframe," +
            "    source,\n" +
            "    target,\n" +
            "    channels_cnt_open,\n" +
            "    channels_cnt_active,\n" +
            "    channels_percent_active,\n" +
            "    is_mainnet\n" +
            "from\n" +
            "    public.get_zones_graphs(:timeframe)";

    String GET_FT_CHANNELS_STATS = "" +
            "select\n" +
            "    zone,\n" +
            "    client_id,\n" +
            "    connection_id,\n" +
            "    channel_id,\n" +
            "    :timeframe as timeframe," +
            "    zone_counerparty,\n" +
            "    is_opened,\n" +
            "    ibc_tx,\n" +
            "    ibc_tx_diff,\n" +
            "    ibc_tx_failed,\n" +
            "    ibc_tx_failed_diff,\n" +
            "    zone_label_url,\n" +
            "    zone_counterparty_label_url,\n" +
            "    zone_readable_name,\n" +
            "    zone_counterparty_readable_name,\n" +
            "    is_zone_counerparty_mainnet,\n" +
            "    zone_label_url2,\n" +
            "    zone_counterparty_label_url2,\n" +
            "    zone_counterparty_channel_id,\n" +
            "    zone_website,\n" +
            "    ibc_cashflow_in,\n" +
            "    ibc_cashflow_in_diff,\n" +
            "    ibc_cashflow_out,\n" +
            "    ibc_cashflow_out_diff,\n" +
            "    ibc_tx_success_rate,\n" +
            "    ibc_tx_success_rate_diff\n" +
            "from\n" +
            "    public.get_ft_chanels_stats(:timeframe)";

    String GET_ZONES_UP_TO_DATE_STATUS = "" +
            "select\n" +
            "    zones.chain_id as zone,\n" +
            "    blocks_log.last_updated_at > (CURRENT_TIMESTAMP at time zone 'utc') - make_interval(hours => 1) as is_zone_up_to_date\n" +
            "from\n" +
            "    zones\n" +
            "left join blocks_log\n" +
            "    on zones.chain_id = blocks_log.zone";
}
