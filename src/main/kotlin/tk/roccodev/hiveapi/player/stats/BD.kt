package tk.roccodev.hiveapi.player.stats
import tk.roccodev.hiveapi.player.PVPStats

/**
 * Main BatteryDash data fetcher
 *
 * Inherits data from PVPStats (kills, deaths)
 *
 *
 */
class BD(player: String) : PVPStats("BD", player) {



    val energyCollected
        get() = jsonObj.int("energy_collected")

    val batteriesCharged
        get() = jsonObj.int("batteries_charged")

    override val recentGames: Array<String>
        get() = arrayOf()

}