package tk.roccodev.hiveapi.http

import com.beust.klaxon.JsonObject
import com.beust.klaxon.Klaxon
import tk.roccodev.hiveapi.player.HivePlayer

import java.net.HttpURLConnection
import java.net.URL

class Download{

    fun hivePlayer(name: String) : HivePlayer? {

       return Klaxon().parse(content(URLs.MAIN_URL + URLs.EP_PLAYER + name))

    }



    fun pStatsObj(name: String, game: String) : JsonObject? {

        var obj : JsonObject = contentWithJson(URLs.MAIN_URL + URLs.EP_PLAYER + name + "/" + game)
        return obj;
    }



    fun contentWithJson(url: String) : JsonObject {
        var conn = URL(url).openConnection() as HttpURLConnection
        conn.setRequestProperty("User-Agent", "RoccoDev/HiveAPIKt on " + System.getProperty("http.agent"))
        try {
            conn.connect()
            return Klaxon().parseJsonObject(conn.inputStream.bufferedReader(Charsets.UTF_8))
        } finally {
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

