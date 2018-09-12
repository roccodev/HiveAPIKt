package tk.roccodev.hiveapi.player.stats
import com.beust.klaxon.JsonObject
import tk.roccodev.hiveapi.http.DownloadObj
import tk.roccodev.hiveapi.player.PVPStats

/**
 * Main BedWars data fetcher
 *
 * Inherits data from PVPStats (kills, deaths)
 *
 *
 */
class BED(player: String) : PVPStats("BED", player) {



    var mode: String = "BED"

    constructor(player: String, theMode: String) : this(player) {
        mode = theMode.toUpperCase()
    }

    override val jsonObj: JsonObject by lazy {
        DownloadObj.pStatsObj(player, mode)!!
    }

    val winstreak
                get() = jsonObj.int("win_streak")

    val bedsDestroyed
                get() = jsonObj.int("beds_destroyed")

    val teamsEliminated
                get() = jsonObj.int("teams_eliminated")


    override val recentGames: Array<String>
        get() = arrayOf()

}