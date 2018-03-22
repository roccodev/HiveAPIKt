package tk.roccodev.hiveapi.player



open class PVPStats(shortcode: String, player: String) : GameStats(shortcode, player){


    val kills : Int
            get() = jsonObj.get("kills") as Int
    val deaths : Int
        get() = jsonObj.get("deaths") as Int


}