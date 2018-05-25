package tk.roccodev.hiveapi.player.stats
import tk.roccodev.hiveapi.player.PVPStats

/**
 * Main Splegg data fetcher
 *
 * Inherits data from PVPStats (deaths)
 *
 *
 */
class SP(player: String) : PVPStats("SP", player) {



    val eggsFired
        get() = jsonObj.int("eggsfired")

    val blocksDestroyed
        get() = jsonObj.int("blocksdestroyed")

    val timeAlive
        get() = jsonObj.int("timealive")

    val rainbowEggs
        get() = jsonObj.boolean("rainboweggs")

    val sheepUnlocked
        get() = jsonObj.boolean("sheepunlock")

    val shovelUpgraded
        get() = jsonObj.boolean("shovelupgrade")


    override val kills = -1

    override val gamesPlayed: Int?
        get() = jsonObj.int("gamesplayed")

    override val points: Int?
        get() = jsonObj.int("points")

    override val firstLogin: Int?
        get() = jsonObj.int("firstlogin")

    override val recentGames: Array<String>
        get() = arrayOf()

}