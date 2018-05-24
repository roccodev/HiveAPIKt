package tk.roccodev.hiveapi.game.lb

import tk.roccodev.hiveapi.http.DownloadObj

class Leaderboard(val game: String, val start: Int, val end: Int) {

    private val profiles = mutableListOf<LeaderboardProfile>()


    init {
        profiles.addAll(DownloadObj.leaderboard(game, start, end))
    }

   fun get(index: Int) = profiles[index]

}