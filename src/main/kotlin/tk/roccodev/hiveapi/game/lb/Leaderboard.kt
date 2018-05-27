package tk.roccodev.hiveapi.game.lb

import tk.roccodev.hiveapi.http.DownloadObj

/**
 * Class representing leaderboard data.
 *
 * @param game the shortcode of the game to fetch the leaderboard of.
 * @param start start index for the leaderboard (starting from 0 for 1st place).
 * @param end end index for the leaderboard.
 *
 * Note: the end/start delta must be less than or equal to 200, and greater than 0.
 */
class Leaderboard(val game: String, val start: Int, val end: Int) {

    private val profiles = mutableListOf<LeaderboardProfile>()


    init {
        profiles.addAll(DownloadObj.leaderboard(game, start, end))
    }

    /**
     * Gets the leaderboard profile corresponding to the given place.
     *
     * @param index the place to consider.
     * @return the fetched profile.
     */
   fun get(index: Int) = profiles[index]

}