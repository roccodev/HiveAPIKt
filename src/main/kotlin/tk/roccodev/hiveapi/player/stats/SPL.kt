package tk.roccodev.hiveapi.player.stats
import com.beust.klaxon.JsonObject
import tk.roccodev.hiveapi.player.PVPStats
import tk.roccodev.hiveapi.player.stats.spl.SploopCharacterStats

/**
 * Main Sploop data fetcher
 *
 * Inherits data from PVPStats (kills, deaths)
 *
 *
 */
class SPL(player: String) : PVPStats("SPL", player) {


    val blocksPainted
        get() = jsonObj.int("blockspainted")

    val ultimatesEarned
        get() = jsonObj.int("ultimates_earned")

    val characterStats : MutableMap<String, SploopCharacterStats>
        get(){
            val json = jsonObj.obj("character_stats")
            val toReturn = mutableMapOf<String, SploopCharacterStats>()
            json?.entries?.forEach {
                val newIt = it.value as JsonObject
                toReturn.put(it.key, SploopCharacterStats(newIt.int("blocks_painted"), newIt.int("kills"), newIt.int("deaths"), newIt.int("games_played"), newIt
                        .int("ultimate_kills")))

            }
         return toReturn
        }


    override val recentGames: Array<String>
        get() = arrayOf()

}