package tk.roccodev.hiveapi.rank

import tk.roccodev.hiveapi.http.Download

/**
 *
 * API Interface for ranks. Use this if you want to get ranks.
 *
 * Refer to {@link tk.roccodev.hiveapi.player.HivePlayer#rank} for player ranks
 *
 *
 */
class Ranks {

    val ranks : MutableList<HiveRank> = mutableListOf()

    init {
        ranks.addAll(Download().downloadRanks())
    }

    /**
     * Gets a rank from the previously cached ranks based on
     * the given criteria (its level in this case).
     *
     * @return such rank.
     */
    fun getRank(id: Int) : HiveRank {
        return ranks.stream().filter { r -> r.id == id }.findAny().get()
    }

    /**
     * Gets a rank from the previously cached ranks based on
     * the given criteria (its name in this case).
     *
     * Note: The name must follow the API's enum's naming conventions,
     * therefore it must follow the same casing as the original one.
     * Currently, all enum values are uppercase.
     *
     * @return such rank.
     */
    fun getRank(enum: String) : HiveRank {
        return ranks.stream().filter { r -> r.enum == enum }.findAny().get()
    }

}
