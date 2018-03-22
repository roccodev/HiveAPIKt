package tk.roccodev.hiveapi.player

import com.beust.klaxon.JsonObject
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



}