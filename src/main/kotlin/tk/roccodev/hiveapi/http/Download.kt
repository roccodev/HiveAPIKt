package tk.roccodev.hiveapi.http

import com.beust.klaxon.JsonArray
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Klaxon
import tk.roccodev.hiveapi.exception.ProfileNotFoundException
import tk.roccodev.hiveapi.game.GameMap
import tk.roccodev.hiveapi.rank.HiveRank
import tk.roccodev.hiveapi.server.AchievementInfo
import tk.roccodev.hiveapi.server.ServerData
import java.io.FileNotFoundException
import java.net.HttpURLConnection
import java.net.URL

/**
 *
 * Utils class to fetch data from the server.
 * Also contains a Klaxon implementation.
 *
 *
 */

val DownloadObj = Download()

class Download {

    /**
     * Fetches player global data
     *
     * @param name The player's name or UUID
     * @return The fetched data
     *
     */
    fun hivePlayer(name: String) : JsonObject? {

        return contentWithJson(URLs.MAIN_URL + URLs.EP_PLAYER + name)


    }


    /**
     * Fetches player game stats data
     *
     * @param name The player's name or UUID
     * @param game The game's shortcode (Refer to http://api.hivemc.com/v1/game/ for a list of shortcodes)
     *
     */
    fun pStatsObj(name: String, game: String) : JsonObject? {

        return contentWithJson(URLs.MAIN_URL + URLs.EP_PLAYER + name + "/" + game)

    }


    fun gameData(shortCode: String) : JsonObject {

        return contentWithJson(URLs.MAIN_URL + URLs.EP_GAME + shortCode)

    }



    fun serverData() : ServerData? {


        // For some reason, sometimes the playercount and uniquecount values appear as an Int, instead of a String

        val pCount = contentWithJson(URLs.MAIN_URL + URLs.EP_SERVER + "playercount").get("count")
        val pToUse = pCount as? Int ?: (pCount as String).toInt()

        val uCount = contentWithJson(URLs.MAIN_URL + URLs.EP_SERVER + "uniquecount").get("count")
        val uToUse = uCount as? Int ?: (uCount as String).toInt()

        val achArray = contentWithJsonArray(URLs.MAIN_URL + URLs.EP_SERVER + "achievements").filterIsInstance<JsonObject>()

        val list = mutableListOf<AchievementInfo>()

        achArray.forEach { a -> run {
            list.add(AchievementInfo(a))
        } }


       return pCount.let { uCount.let { _ -> ServerData((pToUse), uToUse, list) } }

    }


    fun allMapData(shortCode: String) : List<GameMap> {

        val json = contentWithJson(URLs.MAIN_URL + URLs.EP_GAME + shortCode + "/maps")
        val list = mutableListOf<GameMap>()
        json.map.forEach { s, any -> run {

            val j = any as? JsonObject
            list.add(GameMap(j?.string("worldname")!!, j.string("mapname")!!, j.string("mapauthor")!!, j.int("added")!!, s))


        } }

        return list

    }


    /**
     * Fetches the ranks list from the server
     *
     * @return The fetched list of ranks
     */
    fun downloadRanks() : MutableList<HiveRank> {

        var json : JsonObject = contentWithJson(URLs.MAIN_URL + URLs.EP_SERVER + "ranks")
        var list = mutableListOf<HiveRank>()
        json.map.forEach({s: String, any: Any? ->
            run {
                var obj: JsonObject = any as JsonObject
                var rank = HiveRank(s.toInt(), obj.string("enum")!!, obj.string("human")!!)
                list.add(rank)
            }
        })

        return list

    }


    /**
     * Fetches data from the server accepting a MIME type of 'application/json'
     *
     * @param url The URL to fetch data from
     * @return The fetched data as a {@link com.beust.klaxon.JsonObject}
     */
    fun contentWithJson(url: String) : JsonObject {
        var conn = URL(url).openConnection() as HttpURLConnection
        conn.setRequestProperty("User-Agent", "RoccoDev/HiveAPIKt on " + System.getProperty("http.agent"))
        try {
            conn.connect()
            return Klaxon().parseJsonObject(conn.inputStream.bufferedReader(Charsets.UTF_8))
        }
        catch (ex: FileNotFoundException){
            throw ProfileNotFoundException("Profile for URL $url could not be found.")
        }
        finally {
            conn.disconnect()
        }

    }

    /**
     * Fetches data from the server accepting a MIME type of 'application/json'
     * Specifically used for data which are just an array
     *
     * @param url The URL to fetch data from
     * @return The fetched data as a {@link com.beust.klaxon.JsonArray}
     */
    fun contentWithJsonArray(url: String) : JsonArray<*> {
        var conn = URL(url).openConnection() as HttpURLConnection
        conn.setRequestProperty("User-Agent", "RoccoDev/HiveAPIKt on " + System.getProperty("http.agent"))
        try {
            conn.connect()
            return Klaxon().parseJsonArray(conn.inputStream.bufferedReader(Charsets.UTF_8))
        }
        catch (ex: FileNotFoundException){
            throw ProfileNotFoundException("Profile for URL $url could not be found.")
        }
        finally {
            conn.disconnect()
        }

    }




}

