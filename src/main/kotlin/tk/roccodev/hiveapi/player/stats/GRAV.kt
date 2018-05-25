package tk.roccodev.hiveapi.player.stats
import tk.roccodev.hiveapi.game.Achievement
import tk.roccodev.hiveapi.player.GameStats

/**
 * Main Gravity data fetcher
 *
 *
 *
 */
class GRAV(player: String) : GameStats("GRAV", player) {


    override val gamesPlayed: Int?
        get() = jsonObj.int("gamesplayed")

    override val points: Int?
        get() = jsonObj.int("points")

    override val firstLogin: Int?
        get() = jsonObj.int("firstlogin")

    val mapRecords
        get() = jsonObj.obj("maprecords") as? Map<String, Int>

    override val achievements = listOf<Achievement>()

    override val recentGames: Array<String>
        get() = arrayOf()

}