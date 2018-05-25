package tk.roccodev.hiveapi.player.stats
import tk.roccodev.hiveapi.player.GameStats

/**
 * Main DrawIt data fetcher
 *
 *
 *
 */
class DRAW(player: String) : GameStats("DRAW", player) {


    val correctGuesses
        get() = jsonObj.int("correct_guesses")

    val incorrectGuesses
        get() = jsonObj.int("incorrect_guesses")

    val skips
        get() = jsonObj.int("skips")

    override val gamesPlayed: Int?
        get() = jsonObj.int("gamesplayed")

    override val lastLogin: Int?
        get() = jsonObj.int("cached")

    override val recentGames: Array<String>
        get() = arrayOf()

}