package tk.roccodev.hiveapi.game.title

class BEDTitle(override val enum: String,
               val enumGroup: String,
               override val humanName: String,
               override val requiredPoints: Int,
               override val plainName: String )
    : GameTitle(enum, requiredPoints, humanName, plainName)