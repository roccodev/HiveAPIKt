package tk.roccodev.hiveapi.server

import tk.roccodev.hiveapi.http.DownloadObj

class Server(){

    var playerCount = 0
        private set

    var uniqueCount = 0
        private set

    var achievements = listOf<AchievementInfo>()
        private set

    init {

        val data = DownloadObj.serverData()
        playerCount = data?.playerCount!!
        uniqueCount = data.uniqueCount
        achievements = data.achievements

    }


}