package tk.roccodev.hiveapi.player.stats
import tk.roccodev.hiveapi.player.GameStats

/**
 * Main ExplosiveEggs data fetcher
 *
 *
 */
class EE(player: String) : GameStats("EE", player) {


    override val gamesPlayed: Int?
        get() = jsonObj.int("gamesplayed")

    val leaps
        get() = jsonObj.int("leaps")

    override val points: Int?
        get() = jsonObj.int("points")

    override val title
                get() = ""

    override val firstLogin: Int?
        get() = jsonObj.int("firstlogin")

    override val recentGames: Array<String>
        get() = arrayOf()

}