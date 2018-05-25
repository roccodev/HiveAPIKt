package tk.roccodev.hiveapi.player.stats
import tk.roccodev.hiveapi.game.Achievement
import tk.roccodev.hiveapi.player.GameStats

/**
 * Main ElectricFloor data fetcher
 *
 *
 *
 */
class EF(player: String) : GameStats("EF", player) {



    val outlived
        get() = jsonObj.int("outlived")

    val blocksActivated
        get() = jsonObj.int("blocksactivated")

    override val firstLogin: Int?
        get() = jsonObj.int("firstlogin")

    override val gamesPlayed: Int?
        get() = jsonObj.int("gamesplayed")

    override val points: Int?
        get() = jsonObj.int("points")

    override val achievements = listOf<Achievement>()

    override val recentGames: Array<String>
        get() = arrayOf()

}