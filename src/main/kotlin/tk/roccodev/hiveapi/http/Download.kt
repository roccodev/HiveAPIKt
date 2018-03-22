package tk.roccodev.hiveapi.http

import com.beust.klaxon.JsonArray
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Klaxon
import tk.roccodev.hiveapi.exception.ProfileNotFoundException
import tk.roccodev.hiveapi.player.HivePlayer
import tk.roccodev.hiveapi.rank.HiveRank
import java.io.FileNotFoundException

import java.net.HttpURLConnection
import java.net.URL

class Download{

    fun hivePlayer(name: String) : JsonObject? {

        return contentWithJson(URLs.MAIN_URL + URLs.EP_PLAYER + name)


    }



    fun pStatsObj(name: String, game: String) : JsonObject? {

        var obj : JsonObject = contentWithJson(URLs.MAIN_URL + URLs.EP_PLAYER + name + "/" + game)
        return obj;
    }



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


    fun content(url: String) : String{
        var conn = URL(url).openConnection() as HttpURLConnection
        conn.setRequestProperty("User-Agent", "RoccoDev/HiveAPIKt on " + System.getProperty("http.agent"))
        try {
            conn.connect()
            return conn.inputStream.bufferedReader(Charsets.UTF_8).readText()
        } finally {
            conn.disconnect()
        }
    }

}

