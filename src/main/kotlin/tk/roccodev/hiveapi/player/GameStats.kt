package tk.roccodev.hiveapi.player

import com.beust.klaxon.JsonObject
import tk.roccodev.hiveapi.game.Achievement
import tk.roccodev.hiveapi.game.Game
import tk.roccodev.hiveapi.http.DownloadObj
import java.util.stream.Collectors

/**
 *
 * API Interface that acts as a base class for all gamemodes.
 *
 *
 */
open class GameStats(private val shortCode: String, val player: String) {

    protected var jsonObj: JsonObject

    init {
        jsonObj = DownloadObj.pStatsObj(player, shortCode)!!
    }

    val parentGameStats
        get() = Game(shortCode)

    val points
            get() = jsonObj.int("total_points")
   open val gamesPlayed
            get() = jsonObj.int("games_played")

    open val title
            get() = jsonObj.string("title")

    val victories
            get() = jsonObj.int("victories")
    open val lastLogin
            get() = jsonObj.int("lastlogin")
    val firstLogin
            get() = jsonObj.int("firstLogin")

    open val recentGames: Array<String>?
        get() = jsonObj.array<String>("recentgames").orEmpty().toTypedArray()

    val achievements : List<Achievement>
        get(){
            val achObj = jsonObj.obj("achievements")!!
            val list = mutableListOf<Achievement>()
            achObj.map.forEach { s, any -> run {
                if(any is JsonObject){
                    val json = any as? JsonObject
                    val ach = Achievement(json?.int("progress")!!, json.int("unlockedAt")!!)
                    if(json.size > 2){
                        ach.extra = mutableMapOf()
                        ach.extra!!.putAll(json.map.filterNot { entry -> entry.key == "unlockedAt" || entry.key == "progress" })
                    }
                    ach.name = s
                    list.add(ach)
                }
            } }

            return list
        }


    val unlockedAchievements : List<Achievement>
        get() = achievements.filter { achievement -> achievement.unlockedAt != -1 }


}












