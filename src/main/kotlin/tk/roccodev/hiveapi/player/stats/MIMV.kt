package tk.roccodev.hiveapi.player.stats
import tk.roccodev.hiveapi.player.PVPStats

/**
 * Main Murder in Mineville data fetcher
 *
 * Inherits data from PVPStats (kills, deaths)
 *
 *
 */
class MIMV(player: String) : PVPStats("MIMV", player) {



    val lastUsedEmote
        get() = jsonObj.string("lastUsedEmote")

    val preferredEmoteSelectorMenu
        get() = jsonObj.string("preferredEmoteSelectorMenu")

    override val recentGames: Array<String>
        get() = arrayOf()

}