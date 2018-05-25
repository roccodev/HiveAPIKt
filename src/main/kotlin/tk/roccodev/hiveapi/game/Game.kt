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

    val uniquePlayers
        get() = jsonObj.int("uniqueplayers")

    val achievements : List<AchievementInfo>
        get() {
            val list = mutableListOf<AchievementInfo>()
            val achs = jsonObj.array<JsonObject>("achievements")

            achs?.forEach { j -> list.add(AchievementInfo(j)) }

            return list


        }

    val maps
        get() = GameMaps(shortCode)

   fun leaderboard(start: Int, end: Int) = Leaderboard(shortCode, start, end)

}



