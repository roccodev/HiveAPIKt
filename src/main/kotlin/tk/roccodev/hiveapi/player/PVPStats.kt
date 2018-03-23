package tk.roccodev.hiveapi.player


/**
 *
 * API Interface for PVP-based gamemodes
 * This base class includes kills and deaths, common to all PVP gamemodes, except for CAI.
 *
 *
 */
open class PVPStats(shortcode: String, player: String) : GameStats(shortcode, player){


    val kills
            get() = jsonObj.int("kills")
    val deaths
        get() = jsonObj.int("deaths")


}
