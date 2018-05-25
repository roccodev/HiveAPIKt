package tk.roccodev.hiveapi.player


/**
 *
 * API Interface for PVP-based gamemodes
 * This base class includes kills and deaths, common to all PVP gamemodes, except for CAI.
 *
 *
 */
open class PVPStats(shortCode: String, player: String) : GameStats(shortCode, player){


    open val kills
            get() = jsonObj.int("kills")
   open val deaths
        get() = jsonObj.int("deaths")


}
