package tk.roccodev.hiveapi.player.stats
import com.beust.klaxon.JsonArray
import tk.roccodev.hiveapi.player.GameStats
import tk.roccodev.hiveapi.player.PVPStats

/**
 * Main Cowboys and Indians data fetcher
 *
 *
 *
 */
class CAI(player: String) : GameStats("CAI", player) {


    val captured
        get() = jsonObj.int("captured")

    val captures
        get() = jsonObj.int("captures")

    val catches
        get() = jsonObj.int("catches")

    val caught
        get() = jsonObj.int("caught")

    val creeperFirework
        get() = jsonObj.boolean("creeperfirework")

    val teamSelector
        get() = jsonObj.boolean("teamselector")


    override val recentGames: Array<String>
        get() = arrayOf()

}