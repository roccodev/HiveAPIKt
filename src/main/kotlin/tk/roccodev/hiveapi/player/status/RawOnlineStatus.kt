package tk.roccodev.hiveapi.player.status

/**
 *
 * Represents a raw online status.
 * It is fetched through the /player/status/raw endpoint.
 *
 */
class RawOnlineStatus(val status: String, val cached: Long)
