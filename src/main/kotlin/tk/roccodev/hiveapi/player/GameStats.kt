package tk.roccodev.hiveapi.player

import com.beust.klaxon.JsonObject
import tk.roccodev.hiveapi.http.Download


open class GameStats(shortCode: String, player: String) {

    var jsonObj: JsonObject

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



}












