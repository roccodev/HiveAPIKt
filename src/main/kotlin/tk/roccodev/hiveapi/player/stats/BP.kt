package tk.roccodev.hiveapi.player.stats
import com.beust.klaxon.JsonArray
import tk.roccodev.hiveapi.player.PVPStats

/**
 * Main BlockParty data fetcher
 *
 *
 *
 */
class BP(player: String) : PVPStats("BP", player) {


    val selectedBling
        get() = jsonObj.string("selected_bling")

    val selectedDeathSound
        get() = jsonObj.string("selected_death_sound")

    val selectedTrail
        get() = jsonObj.string("selected_trail")

    val selectedVictorySound
        get() = jsonObj.string("selected_victory_sound")

    val narrationDisabled
        get() = jsonObj.boolean("wing_disable_narration")

    val unlockedBlings
        get() = subStringAccordingly(jsonObj.string("unlocked_bling"))?.split(",")

    val unlockedDeathSounds
        get() = subStringAccordingly(jsonObj.string("unlocked_death_sounds"))?.split(",")

    val unlockedTrails
        get() = subStringAccordingly(jsonObj.string("unlocked_trails"))?.split(",")

    val eliminations
        get() = jsonObj.int("total_eliminations")

    val placings
        get() = jsonObj.int("total_placings")

    override val recentGames: Array<String>
        get() = arrayOf()


    private fun subStringAccordingly(input: String?) : String? {
        return input?.substring(0, input.length - 1)
    }

}