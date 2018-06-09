package tk.roccodev.hiveapi.player.stats
import tk.roccodev.hiveapi.player.PVPStats

/**
 * Main DeathRun data fetcher
 *
 * Inherits data from PVPStats (kills, deaths)
 *
 *
 */
class DR(player: String) : PVPStats("DR", player) {


        val trapsActivated
            get() = jsonObj.int("trapsActivated")

        val gamesPlayedAsRunner
            get() = jsonObj.int("runnergamesplayed")

        val gamesPlayedAsDeath
            get() = jsonObj.int("deathgamesplayed")

        val victoriesAsRunner
            get() = jsonObj.int("runnerwins")

        val victoriesAsDeath
            get() = jsonObj.int("deathwins")

        val totalCheckpoints
            get() = jsonObj.int("totalcheckpoints")

        val selectedVisibility
            get() = jsonObj.string("visibility")

        val multiKills
            get() = jsonObj.obj("multikills").orEmpty()

        val mapRecords
            get() = jsonObj.obj("maprecords").orEmpty()


}