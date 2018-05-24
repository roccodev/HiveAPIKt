package tk.roccodev.hiveapi.game

import tk.roccodev.hiveapi.http.DownloadObj

class Games() : HashMap<String, String>() {


    val list = DownloadObj.gamesList()

    init {
        putAll(list)
    }


}