package tk.roccodev.hiveapi.player.stats
import tk.roccodev.hiveapi.player.PVPStats

class BED(player: String) : PVPStats("BED", player) {


    val bedsDestroyed
                get() = jsonObj.int("beds_destroyed")

    val teamsEliminated
                get() = jsonObj.int("teams_eliminated")

}