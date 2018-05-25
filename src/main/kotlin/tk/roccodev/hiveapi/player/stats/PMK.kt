package tk.roccodev.hiveapi.player.stats
import tk.roccodev.hiveapi.player.PVPStats

/**
 * Main Pumpkinfection data fetcher
 *
 * Inherits data from PVPStats (kills, deaths)
 *
 *
 */
class PMK(player: String) : PVPStats("PMK", player) {


    override val deaths: Int?
        get() = infections

    val infections
        get() = jsonObj.int("infections")

    override val title
                get() = ""

    override val lastLogin: Int?
        get() = jsonObj.int("cached")

    override val recentGames: Array<String>
        get() = arrayOf()

}