package tk.roccodev.hiveapi.player



open class PVPStats(shortcode: String, player: String) : GameStats(shortcode, player){


    val kills
            get() = jsonObj.int("kills")
    val deaths
        get() = jsonObj.int("deaths")


}
