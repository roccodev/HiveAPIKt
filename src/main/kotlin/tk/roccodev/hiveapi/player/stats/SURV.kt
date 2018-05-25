package tk.roccodev.hiveapi.player.stats
import tk.roccodev.hiveapi.player.PVPStats

/**
 * Main Survive The Night data fetcher
 *
 * Inherits data from PVPStats (kills, deaths)
 *
 *
 */
class SURV(player: String) : PVPStats("SURV", player) {



    val generatorsPowered
        get() = jsonObj.int("generators_powered")

    val lootedCrates
        get() = jsonObj.int("looted_crates")

    override val recentGames: Array<String>
        get() = arrayOf()

}