package tk.roccodev.hiveapi.player.stats
import tk.roccodev.hiveapi.player.PVPStats

/**
 * Main BedWars data fetcher
 *
 * Inherits data from PVPStats (kills, deaths)
 *
 *
 */
class BED(player: String) : PVPStats("BED", player) {



    val bedsDestroyed
                get() = jsonObj.int("beds_destroyed")

    val teamsEliminated
                get() = jsonObj.int("teams_eliminated")

    override val title
                get() = ""

    override val recentGames: Array<String>
        get() = arrayOf()

}