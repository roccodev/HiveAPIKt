package tk.roccodev.hiveapi.game.title

/**
 * Represents a title object.
 *
 * @param enum the uppercase name.
 * @param requiredPoints the required points.
 * @param humanName the human-friendly name, colored.
 * @param plainName the human-friendly name, with color codes stripped away.
 *
 */
open class GameTitle(open val enum: String?, open val requiredPoints: Int?, open val humanName: String?, open val plainName: String?)

