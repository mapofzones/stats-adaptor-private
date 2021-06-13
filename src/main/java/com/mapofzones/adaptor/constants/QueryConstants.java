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
            "    ibc_tx_30d_failed_diff\n" +
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
            "    stats.top_zone_pair\n" +
            "from " +
            "    get_total_stats(:timeframe, :chart_step) stats";

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
            "    stats.total_coin_turnover_amount_diff\n" +
            "from\n" +
            "    get_full_stats_for_each_zone(:timeframe, :chart_step) stats";

    String GET_GRAPHS_BY_TIMEFRAME = "" +
            "with zones_full_graph as (\n" +
            "  select\n" +
            "    distinct zone_src as source,\n" +
            "    zone_dest as target\n" +
            "  from\n" +
            "    ibc_transfer_hourly_stats -- where\n" +
            "    -- hour > (CURRENT_TIMESTAMP at time zone 'utc') - make_interval(hours => period_in_hours)\n" +
            "),\n" +
            "zones_single_graph as (\n" +
            "  select\n" +
            "    distinct source as source,\n" +
            "    target as target\n" +
            "  from\n" +
            "    (\n" +
            "      select\n" +
            "        source as source,\n" +
            "        target as target\n" +
            "      from\n" +
            "        zones_full_graph\n" +
            "      union all\n" +
            "      select\n" +
            "        target as source,\n" +
            "        source as target\n" +
            "      from\n" +
            "        zones_full_graph\n" +
            "    ) as double_graph\n" +
            "  where\n" +
            "    source < target\n" +
            ")\n" +
            "\n" +
            "\n" +
            "select\n" +
            "    :timeframe as timeframe," +
            "    source,\n" +
            "    target\n" +
            "from\n" +
            "  zones_single_graph";
}
