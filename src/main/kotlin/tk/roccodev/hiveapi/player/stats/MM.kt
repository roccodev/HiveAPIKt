package tk.roccodev.hiveapi.player.stats
import tk.roccodev.hiveapi.game.Achievement
import tk.roccodev.hiveapi.player.GameStats

/**
 * Main MusicMasters data fetcher
 *
 * Inherits data from PVPStats (kills, deaths)
 *
 *
 */
class MM(player: String) : GameStats("MM", player) {


    override val gamesPlayed: Int?
        get() = jsonObj.int("gamesplayed")

    override val points: Int?
        get() = jsonObj.int("points")

    val correctNotes
        get() = jsonObj.int("correctnotes")

    val incorrectNotes
        get() = jsonObj.int("incorrectnotes")

    val perfectNotes
        get() = jsonObj.int("notes_perfect")

    val goodNotes
        get() = jsonObj.int("notes_good")

    override val firstLogin: Int?
        get() = jsonObj.int("firstlogin")

    override val achievements = listOf<Achievement>()

    override val recentGames: Array<String>
        get() = arrayOf()

}