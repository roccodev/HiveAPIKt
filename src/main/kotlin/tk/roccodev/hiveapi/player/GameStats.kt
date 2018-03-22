package tk.roccodev.hiveapi.player

import com.beust.klaxon.JsonObject
import tk.roccodev.hiveapi.game.Achievement
import tk.roccodev.hiveapi.http.Download


open class GameStats(shortCode: String, val player: String) {

    internal var jsonObj: JsonObject

    init {
        jsonObj = Download().pStatsObj(player, shortCode)!!
    }

    val points : Int
            get() = jsonObj.get("total_points") as Int
    val gamesPlayed : Int
            get() = jsonObj.get("games_played") as Int
    val victories : Int
            get() = jsonObj.get("victories") as Int
    val lastLogin : Int
            get() = jsonObj.get("lastlogin") as Int
    val firstLogin : Int
            get() = jsonObj.get("firstLogin") as Int

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












