package tk.roccodev.hiveapi.player.stats
import tk.roccodev.hiveapi.player.PVPStats

/**
 * Main SG:Heroes data fetcher
 *
 * Inherits data from PVPStats (kills, deaths)
 *
 *
 */
class HERO(player: String) : PVPStats("HERO", player) {


    val deathmatches
        get() = jsonObj.int("deathmatches")

    val oneVsOneVictories
        get() = jsonObj.int("one_vs_ones_wins")

    val tntUsed
        get() = jsonObj.int("tnt_used")

    val foodConsumed
        get() = jsonObj.int("food_consumed")

    val cratesOpened
        get() = jsonObj.int("crates_opened")

    override val title: String?
        get() = ""

    override val firstLogin: Int?
        get() = jsonObj.int("firstlogin")

    override val recentGames: Array<String>
        get() = arrayOf()

}