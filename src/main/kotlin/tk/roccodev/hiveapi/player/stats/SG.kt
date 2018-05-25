package tk.roccodev.hiveapi.player.stats
import tk.roccodev.hiveapi.player.PVPStats

/**
 * Main Survival Games (1) data fetcher
 *
 * Inherits data from PVPStats (kills, deaths)
 *
 *
 */
class SG(player: String) : PVPStats("SG", player) {


    val mostPoints
        get() = jsonObj.int("most_points")

    val cratesOpened
        get() = jsonObj.int("cratesopened")

    val deathmatches
        get() = jsonObj.int("deathmatches")

    val timeAlive
        get() = jsonObj.int("timealive")

    val deathCrateUnlocked
        get() = jsonObj.boolean("unlock_deathcrate")

    val mySwordUnlocked
        get() = jsonObj.boolean("unlock_mysword")

    val vanityColors
        get() = subStringAccordingly(jsonObj.string("vanitycolors"))?.split(",")

    val arrowTrails
        get() = subStringAccordingly(jsonObj.string("arrowtrails"))?.split(",")

    val battleCries
        get() = subStringAccordingly(jsonObj.string("battlecries"))?.split(",")

    val activeVanityColor
        get() = jsonObj.int("active_vanitycolor")

    val activeDeathCrate
        get() = jsonObj.boolean("active_deathcrate")

    val firstWinDay
        get() = jsonObj.int("firstwinday")

    override val gamesPlayed: Int?
        get() = jsonObj.int("gamesplayed")

    override val title: String?
        get() = ""

    private fun subStringAccordingly(input: String?) : String? {
        return input?.substring(0, input.length - 1)
    }

}