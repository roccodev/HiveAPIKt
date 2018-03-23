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

    fun getRank(id: Int) : HiveRank {
        return ranks.stream().filter { r -> r.id == id }.findAny().get()
    }

    fun getRank(enum: String) : HiveRank {
        return ranks.stream().filter { r -> r.enum == enum }.findAny().get()
    }

}
