package tk.roccodev.hiveapi.player.stats
import tk.roccodev.hiveapi.player.GameStats

/**
 * Main TheLab data fetcher
 *
 *
 *
 */
class LAB(player: String) : GameStats("LAB", player) {


    override val gamesPlayed: Int?
        get() = jsonObj.int("gamesplayed")

    val gameVictories
        get() = jsonObj.obj("game_victories") as? Map<String, Int>

    override val recentGames: Array<String>
        get() = arrayOf()

}