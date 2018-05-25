package tk.roccodev.hiveapi.player.stats
import tk.roccodev.hiveapi.player.PVPStats

/**
 * Main Cranked data fetcher
 *
 * Inherits data from PVPStats (kills, deaths)
 *
 *
 */
class CR(player: String) : PVPStats("CR", player) {


    val rcCatCount
        get() = jsonObj.int("rccat_count")

    val rcCatKills
        get() = jsonObj.int("rccat_kills")

    val airstrikeCount
        get() = jsonObj.int("airstrike_count")

    val airstrikeKills
        get() = jsonObj.int("airstrike_kills")

    val sonicSquidCount
        get() = jsonObj.int("sonicsquid_count")

    val sonicSquidKills
        get() = jsonObj.int("sonicsquid_kills")

    override val gamesPlayed: Int?
        get() = jsonObj.int("gamesplayed")

    override val firstLogin: Int?
        get() = jsonObj.int("firstlogin")

    override val recentGames: Array<String>
        get() = arrayOf()

}