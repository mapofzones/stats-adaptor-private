package com.mapofzones.adaptor.constants;

public class QueryConstants {
    public static final String GET_HEADER_BY_TIMEFRAME = "" +
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
    public static final String GET_ZONES_STATS_BY_TIMEFRAME = "" +
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
            "    stats.ibc_tx_out_weight\n" +
            "from\n" +
            "    get_full_stats_for_each_zone(:timeframe, :chart_step) stats";

    private QueryConstants() {
    }
}
