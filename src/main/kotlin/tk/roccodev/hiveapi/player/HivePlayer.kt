package tk.roccodev.hiveapi.player

import com.beust.klaxon.JsonArray
import com.beust.klaxon.JsonObject
import tk.roccodev.hiveapi.game.Achievement
import tk.roccodev.hiveapi.http.DownloadObj
import tk.roccodev.hiveapi.player.status.OnlineStatus
import tk.roccodev.hiveapi.player.status.RawOnlineStatus
import tk.roccodev.hiveapi.rank.HiveRank


/**
 *
 * API Interface for player global stats
 *
 *
 */
class HivePlayer(val usernameOrUUID: String) {

    internal var jsonObj : JsonObject = DownloadObj.hivePlayer(usernameOrUUID)!!

    val rawStatus: RawOnlineStatus
            get() {
               return getRawStatus(usernameOrUUID)
            }

    val username
            get() = jsonObj.string("username")
    val uuid
            get() = jsonObj.string("UUID")


    val medals
            get() = jsonObj.int("medals")

    val tokens
            get() = jsonObj.int("tokens")

    val crates
            get() = jsonObj.int("crates")

    val firstLogin
            get() = jsonObj.int("firstLogin")

    val lastLogin
            get() = jsonObj.int("lastLogin")

    val lastLogout
            get() = jsonObj.int("lastLogout")

    val rank : HiveRank
            get() {
                val rankObj = jsonObj.obj("modernRank")!!
                return HiveRank(rankObj.int("index")!!, rankObj.string("enum")!!, rankObj.string("human")!!)
            }

    val status : OnlineStatus
            get(){
                val statusObj = jsonObj.obj("status")!!
                return OnlineStatus(statusObj.string("description")!!, statusObj.string("game")!!)
            }

    val achievements : List<Achievement>
            get(){
                val achObj = jsonObj.obj("achievements")!!
                val list = mutableListOf<Achievement>()
                achObj.map.forEach { s, any -> run {
                    if(any is JsonObject){
                        val ach = Achievement(any.int("progress")!!, any.int("unlockedAt")!!)
                        if(any.size > 2){
                            ach.extra = mutableMapOf()
                            ach.extra!!.putAll(any.map.filterNot { entry -> entry.key == "unlockedAt" || entry.key == "progress" })
                        }
                        ach.name = s
                        list.add(ach)
                    }
                } }

                return list
            }


    val currentBPServer: String?
        get() {
           return getBPServer(username!!)
        }

    val unlockedAchievements : List<Achievement>
                    get() = achievements.filter { achievement -> achievement.unlockedAt != -1 }


    val trophies : List<Trophy>
                    get(){
                        val tObj : JsonArray<JsonObject> = jsonObj.array("trophies")!!
                        val list = mutableListOf<Trophy>()

                        tObj.forEach { j -> list.add(Trophy(j.string("game")!!, j.string("achievement")!!)) }
                        return list
                    }



}