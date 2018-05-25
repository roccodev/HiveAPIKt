package tk.roccodev.hiveapi.player.stats
import tk.roccodev.hiveapi.player.PVPStats

/**
 * Main SkyWars data fetcher
 *
 * Inherits data from PVPStats (kills, deaths)
 *
 *
 */
class SKY(player: String) : PVPStats("SKY", player) {


    override val gamesPlayed: Int?
        get() = jsonObj.int("gamesplayed")

    val mostPoints
        get() = jsonObj.int("most_points")

    val timeAlive
        get() = jsonObj.int("timealive")


}