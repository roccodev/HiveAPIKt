package tk.roccodev.hiveapi.player.stats
import tk.roccodev.hiveapi.player.GameStats

/**
 * Main RestaurantRush data fetcher
 *
 *
 *
 */
class RR(player: String) : GameStats("RR", player) {



    val tablesCleared
        get() = jsonObj.int("tablescleared")

    val highScore
        get() = jsonObj.int("highscore")

    override val gamesPlayed: Int?
        get() = jsonObj.int("gamesplayed")

    override val points: Int?
        get() = jsonObj.int("points")

    override val title = ""

    override val firstLogin: Int?
        get() = jsonObj.int("firstlogin")

    override val recentGames: Array<String>
        get() = arrayOf()

}