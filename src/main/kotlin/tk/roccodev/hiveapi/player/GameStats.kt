package tk.roccodev.hiveapi.player

import com.beust.klaxon.JsonObject
import tk.roccodev.hiveapi.game.Achievement
import tk.roccodev.hiveapi.game.Game
import tk.roccodev.hiveapi.http.DownloadObj

/**
 *
 * API Interface that acts as a base class for all gamemodes.
 *
 * @property shortCode the gamemode's shortcode (e.g, 'BED');
 * @property player the player whose info is fetched, can be either their name or their UUID.
 *
 * @see tk.roccodev.hiveapi.game.Games for a list of shortcodes; subclasses of this class are also named after them.
 *
 */
open class GameStats(private val shortCode: String, val player: String) {

    protected open val jsonObj: JsonObject by lazy {
        DownloadObj.pStatsObj(player, shortCode)!!
    }

    /**
     * Creates an instance of the Game object corresponding to the current gamemode.
     *
     * Note: It's not recommended to purely instantiate a GameStats class just to fetch the parent mode;
     * @see Game 's constructor for a more efficient way to get a Game object.
     */
    val parentGameStats
        get() = Game(shortCode)


    /**
     * The specified player's UUID, with the hyphens stripped away.
     */
    val uuid
        get() = jsonObj.string("UUID")

    /**
     * The player's points.
     */
    open val points
            get() = jsonObj.int("total_points")

    /**
     * The amount of games the player has played, or -1 if the mode doesn't support this.
     */
    open val gamesPlayed
            get() = jsonObj.int("games_played")

    /**
     * The rank shown in-game, based on points or other stats.
     */
    open val title
            get() = jsonObj.string("title")

    /**
     * The amount of games the player has won, or -1 if the mode doesn't support this.
     */
    open val victories
            get() = jsonObj.int("victories")

    /**
     * Amount of seconds since epoch until the player has last logged onto the gamemode.
     *
     * @see tk.roccodev.hiveapi.util.dateFromHiveSeconds to convert such seconds into a Date.
     */
    open val lastLogin
            get() = jsonObj.int("lastlogin")

    /**
     * Amount of seconds since epoch until the player had first logged onto the gamemode.
     *
     * @see tk.roccodev.hiveapi.util.dateFromHiveSeconds to convert such seconds into a Date.
     */
    open val firstLogin
            get() = jsonObj.int("firstLogin")

    /**
     * Fetches the recent games of the given player.
     *
     * Note: Not every gamemode supports this feature.
     */
    open val recentGames: Array<String>?
        get() = jsonObj.array<String>("recentgames").orEmpty().toTypedArray()

    /**
     * Fetches the achievements of the given player, for the given mode;
     *
     * Note: Not every gamemode supports this feature; the majority does.
     *
     */
    open val achievements : List<Achievement>
        get(){
            val achObj = jsonObj.obj("achievements")!!
            val list = mutableListOf<Achievement>()
            achObj.map.forEach { s, any -> run {
                if(any is JsonObject){
                    val json = any as? JsonObject
                    val ach = Achievement(json?.int("progress")!!, json.int("unlockedAt")!!)
                    if(json.size > 2){
                        ach.extra = mutableMapOf()
                        ach.extra!!.putAll(json.map.filterNot { entry -> entry.key == "unlockedAt" || entry.key == "progress" })
                    }
                    ach.name = s
                    list.add(ach)
                }
            } }

            return list
        }

    /**
     * Fetches the achievements of the given player, and returns the ones the player has unlocked.
     *
     */
    val unlockedAchievements : List<Achievement>
        get() = achievements.filter { achievement -> achievement.unlockedAt != -1 }


}












