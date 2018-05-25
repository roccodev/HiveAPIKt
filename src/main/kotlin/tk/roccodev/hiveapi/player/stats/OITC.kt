package tk.roccodev.hiveapi.player.stats
import tk.roccodev.hiveapi.player.PVPStats

/**
 * Main OneInTheChamber data fetcher
 *
 * Inherits data from PVPStats (kills, deaths)
 *
 *
 */
class OITC(player: String) : PVPStats("OITC", player) {



    val cupidUnlocked
        get() = jsonObj.boolean("cupidunlock")

    val rainbowUnlocked
        get() = jsonObj.boolean("rainbowunlock")

    val musicUnlocked
        get() = jsonObj.boolean("musicunlock")

    val herobrineUnlocked
        get() = jsonObj.boolean("herobrineunlock")

    override val firstLogin: Int?
        get() = jsonObj.int("firstlogin")

    override val gamesPlayed: Int?
        get() = jsonObj.int("gamesplayed")

    override val recentGames: Array<String>
        get() = arrayOf()

}