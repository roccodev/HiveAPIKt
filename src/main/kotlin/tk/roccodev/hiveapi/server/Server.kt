package tk.roccodev.hiveapi.server

import com.beust.klaxon.JsonArray
import tk.roccodev.hiveapi.http.DownloadObj

class Server(){

    var playerCount = 0
        private set

    var uniqueCount = 0
        private set

    var achievements = listOf<AchievementInfo>()
        private set


    val staffMembers : Map<Int, Array<String>>
        get() {

            val json = DownloadObj.staffData()
            val toReturn = mutableMapOf<Int, Array<String>>()
            json?.entries?.forEach {
                val arr = it.value as JsonArray<String>

                toReturn.put(it.key.toInt(), arr.toTypedArray())

            }
            return toReturn

        }

    init {

        val data = DownloadObj.serverData()
        playerCount = data?.playerCount!!
        uniqueCount = data.uniqueCount
        achievements = data.achievements

    }


}