package tk.roccodev.hiveapi.server

import com.beust.klaxon.JsonObject
import tk.roccodev.hiveapi.game.Achievement

class AchievementInfo(val jsonObj: JsonObject) : Achievement(-1, -1) {


    val publicName
        get() = jsonObj.string("publicname")

    val description
        get() = jsonObj.string("description")

    val stages
        get() = jsonObj.int("stages")

    val secret
        get() = jsonObj.boolean("secret")

    val custom
        get() = jsonObj.boolean("custom")

    val disabled
        get() = jsonObj.boolean("disabled")

    val enabled
        get() = !disabled!!

    val rewardType
        get() = jsonObj.string("rewardtype")

    val rewardArguments
        get() = jsonObj.string("rewardarguments")


}