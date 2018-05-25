package tk.roccodev.hiveapi.player.stats
import tk.roccodev.hiveapi.player.GameStats

/**
 * Main BedWars data fetcher
 *
 * Inherits data from PVPStats (kills, deaths)
 *
 *
 */
class TIMV(player: String) : GameStats("TIMV", player) {


    val karmaRecord
        get() = jsonObj.int("mostPoints")

    val traitorPoints
        get() = jsonObj.int("t_points")

    val detectivePoints
        get() = jsonObj.int("d_points")

    val innocentPoints
        get() = jsonObj.int("i_points")

    val totalRolePoints
        get() = jsonObj.int("role_points")

    val detectiveBook
        get() = jsonObj.boolean("detectivebook")


    override val recentGames: Array<String>
        get() = arrayOf()

}