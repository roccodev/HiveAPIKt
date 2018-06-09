package tk.roccodev.hiveapi.game

/**
 * Represents a title object.
 *
 * @param enum the uppercase name.
 * @param requiredPoints the required points.
 * @param humanName the human-friendly name, colored.
 * @param plainName the human-friendly name, with color codes stripped away.
 *
 */
class GameTitle(val enum: String?, val requiredPoints: Int?, val humanName: String?, val plainName: String?)

