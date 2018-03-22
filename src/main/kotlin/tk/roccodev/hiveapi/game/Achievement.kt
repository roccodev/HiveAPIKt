package tk.roccodev.hiveapi.game

class Achievement(val progress: Int, val unlockedAt: Int) {


    var extra : MutableMap<String, Any?>? = null // For achievements like THESWARM, which have extra
                                                 // data (from: String, game: String)

    var name : String = ""


}