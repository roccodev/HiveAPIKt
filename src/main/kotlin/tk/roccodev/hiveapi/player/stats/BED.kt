package tk.roccodev.hiveapi.player.stats
import tk.roccodev.hiveapi.player.PVPStats

class BED(player: String) : PVPStats("BED", player) {


    val bedsDestroyed : Int
                get() = jsonObj.get("beds_destroyed") as Int

}