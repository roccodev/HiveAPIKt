package tk.roccodev.hiveapi.player

import com.beust.klaxon.JsonObject
import tk.roccodev.hiveapi.game.Achievement
import tk.roccodev.hiveapi.http.Download
import tk.roccodev.hiveapi.player.status.OnlineStatus
import tk.roccodev.hiveapi.rank.HiveRank
import java.util.*

class HivePlayer(val usernameOrUUID: String) {

    internal var jsonObj : JsonObject

    init {
        jsonObj = Download().hivePlayer(usernameOrUUID)!!
    }

    val username
            get() = jsonObj.string("username")!!
    val uuid
            get() = jsonObj.string("UUID")!!



    val rank : HiveRank
            get() {
                var rankObj = jsonObj.obj("modernRank")!!
                return HiveRank(rankObj.int("index")!!, rankObj.string("enum")!!, rankObj.string("human")!!)
            }

    val status : OnlineStatus
            get(){
                var statusObj = jsonObj.obj("status")!!
                return OnlineStatus(statusObj.string("description")!!, statusObj.string("game")!!)
            }

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



}