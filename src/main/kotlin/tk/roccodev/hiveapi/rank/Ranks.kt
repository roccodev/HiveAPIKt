package tk.roccodev.hiveapi.rank

import tk.roccodev.hiveapi.http.Download

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
