package tk.roccodev.hiveapi.player

import com.beust.klaxon.JsonObject
import tk.roccodev.hiveapi.http.Download
import tk.roccodev.hiveapi.rank.HiveRank
import java.util.*

class HivePlayer(val usernameOrUUID: String) {

    private var jsonObj : JsonObject

    init {
        jsonObj = Download().hivePlayer(usernameOrUUID)!!
    }

    val username
            get() = jsonObj.string("username")!!
    val uuid
            get() = jsonObj.string("UUID")!!

    private var rankObj = jsonObj.obj("modernRank")!!

    val rank : HiveRank
            get() = HiveRank(rankObj.int("index")!!, rankObj.string("enum")!!, rankObj.string("human")!!)


}