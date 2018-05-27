package tk.roccodev.hiveapi.game

import com.beust.klaxon.JsonObject
import tk.roccodev.hiveapi.game.lb.Leaderboard
import tk.roccodev.hiveapi.http.DownloadObj
import tk.roccodev.hiveapi.server.AchievementInfo

/**
 *
 * API Interface for game stats (e.g., playercount)
 *
 * @param shortCode The gamemode's shortcode
 *
 * Note: we don't need a separate class for each gamemode,
 * we can just change the 'shortCode' parameter.
 *
 */
class Game(val shortCode: String){

    var jsonObj: JsonObject
        private set


    init {
        jsonObj = DownloadObj.gameData(shortCode)
    }

    /**
     * The unique players of the gamemode.
     */
    val uniquePlayers
        get() = jsonObj.int("uniqueplayers")

    /**
     * Array/List of achievements of the mode (Not including the map ones).
     */
    val achievements : List<AchievementInfo>
        get() {
            val list = mutableListOf<AchievementInfo>()
            val achs = jsonObj.array<JsonObject>("achievements")

            achs?.forEach { j -> list.add(AchievementInfo(j)) }

            return list


        }

    /**
     * List of title objects registered in the gamemode.
     */
    val titles
        get() = DownloadObj.titles(shortCode)


    /**
     * List of maps registered in the gamemode.
     */
    val maps
        get() = GameMaps(shortCode)

    /**
     * Same result as instantiating a Leaderboard object with the game's shortCode, start and end.
     *
     * @param start start index for the leaderboard (starting from 0 for 1st place).
     * @param end end index for the leaderboard.
     *
     * @see Leaderboard
     * @return the fetched Leaderboard object.
     */
   fun leaderboard(start: Int, end: Int) = Leaderboard(shortCode, start, end)

}



