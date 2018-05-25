package tk.roccodev.hiveapi.player.stats
import tk.roccodev.hiveapi.game.Achievement
import tk.roccodev.hiveapi.player.PVPStats

/**
 * Main SurvivalGames 2 data fetcher
 *
 * Inherits data from PVPStats (kills, deaths)
 *
 *
 */
class SGN(player: String) : PVPStats("SGN", player) {



    val mostPoints
        get() = jsonObj.int("most_points")

    val cratesOpened
        get() = jsonObj.int("crates_opened")

    val deathmatches
        get() = jsonObj.int("deathmatches")

    override val achievements = listOf<Achievement>()

    override val title: String?
        get() = ""



}