package tk.roccodev.hiveapi.player.stats
import tk.roccodev.hiveapi.player.PVPStats

/**
 * Main Slaparoo data fetcher
 *
 * Inherits data from PVPStats (kills, deaths)
 *
 *
 */
class SLAP(player: String) : PVPStats("SLAP", player) {

    override val points: Int?
        get() = jsonObj.int("points")

    override val gamesPlayed: Int?
        get() = jsonObj.int("gamesplayed")

    override val firstLogin: Int?
        get() = jsonObj.int("firstlogin")

    override val recentGames: Array<String>
        get() = arrayOf()

}