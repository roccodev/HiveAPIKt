package tk.roccodev.hiveapi.player

import com.beust.klaxon.JsonObject
import tk.roccodev.hiveapi.game.Achievement
import tk.roccodev.hiveapi.http.Download


open class GameStats(shortCode: String, val player: String) {

    internal var jsonObj: JsonObject

    init {
        jsonObj = Download().pStatsObj(player, shortCode)!!
    }

    val points
            get() = jsonObj.int("total_points")
    val gamesPlayed
            get() = jsonObj.int("games_played")
    val victories
            get() = jsonObj.int("victories")
    val lastLogin
            get() = jsonObj.int("lastlogin")
    val firstLogin
            get() = jsonObj.int("firstLogin")

    val achievements : List<Achievement>
        get(){
            var achObj = jsonObj.obj("achievements")!!
            var list = mutableListOf<Achievement>()
            achObj.map.forEach { s, any -> run {
                if(any is JsonObject){
                    var json = any as JsonObject
                    var ach = Achievement(json.int("progress")!!, json.int("unlockedAt")!!)
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












