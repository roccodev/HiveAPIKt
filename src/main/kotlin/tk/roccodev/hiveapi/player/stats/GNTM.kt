package tk.roccodev.hiveapi.player.stats
import tk.roccodev.hiveapi.game.Achievement
import tk.roccodev.hiveapi.player.PVPStats

/**
 * Main SkyGiants:Mini data fetcher
 *
 * Inherits data from PVPStats (kills, deaths)
 *
 *
 */
class GNTM(player: String) : PVPStats("GNTM", player) {



    val goldEarned
        get() = jsonObj.int("gold_earned")

    val beastsSlain
        get() = jsonObj.int("beasts_slain")

    val shutdowns
        get() = jsonObj.int("shutdowns")

    override val achievements = listOf<Achievement>()

    override val recentGames: Array<String>
        get() = arrayOf()

}