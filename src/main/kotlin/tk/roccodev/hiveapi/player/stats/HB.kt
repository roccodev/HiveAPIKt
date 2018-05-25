package tk.roccodev.hiveapi.player.stats
import tk.roccodev.hiveapi.player.PVPStats

/**
 * Main TheHerobrine data fetcher
 *
 * Inherits data from PVPStats (kills, deaths)
 *
 *
 */
class HB(player: String) : PVPStats("HB", player) {


    val captures
        get() = jsonObj.int("captures")

    val unlockedClasses
        get() = subStringAccordingly(jsonObj.string("unlocked_classes"))?.split(",")

    val activeClass
        get() = jsonObj.string("active_class")

    override val points: Int?
        get() = jsonObj.int("points")

    override val gamesPlayed: Int?
        get() = -1

    override val victories
        get() = -1

    override val recentGames: Array<String>
        get() = arrayOf()

    override val firstLogin: Int?
        get() = jsonObj.int("firstlogin")

    override val lastLogin: Int?
        get() = jsonObj.int("cached")

    private fun subStringAccordingly(input: String?) : String? {
        return input?.substring(0, input.length - 1)
    }

}