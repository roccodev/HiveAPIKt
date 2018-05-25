package tk.roccodev.hiveapi.player.stats
import tk.roccodev.hiveapi.player.PVPStats

/**
 * Main HideAndSeek data fetcher
 *
 * Inherits data from PVPStats (kills, deaths)
 *
 *
 */
class HIDE(player: String) : PVPStats("HIDE", player) {


    val killsAsSeeker
        get() = jsonObj.int("seekerkills")

    val killsAsHider
        get() = jsonObj.int("hiderkills")

    val bookUpgrade
        get() = jsonObj.boolean("bookupgrade")

    val timeAlive
        get() = jsonObj.int("timealive")

    val blockExperience
        get() = jsonObj.obj("rawBlockExperience") as? Map<String, Int>

    val blockLevels
        get() = jsonObj.obj("blockExperience") as? Map<String, Int>

    val blocks
        get() = subStringAccordingly(jsonObj.string("blocks"))?.split(",")

    override val kills: Int?
        get() = killsAsHider?.let { killsAsSeeker?.plus(it) }

    override val gamesPlayed: Int?
        get() = jsonObj.int("gamesplayed")

    override val firstLogin: Int?
        get() = jsonObj.int("firstLogin")

    override val recentGames: Array<String>
        get() = arrayOf()


    private fun subStringAccordingly(input: String?) : String? {
        return input?.substring(0, input.length - 1)
    }
}