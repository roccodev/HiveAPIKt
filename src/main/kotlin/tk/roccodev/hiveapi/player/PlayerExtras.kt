@file:JvmName("PlayerExtras")
package tk.roccodev.hiveapi.player

import tk.roccodev.hiveapi.http.DownloadObj
import tk.roccodev.hiveapi.player.status.RawOnlineStatus


fun getRawStatus(usernameOrUUID: String) : RawOnlineStatus {
    val rawStatus = DownloadObj.statusRaw(usernameOrUUID)
    return RawOnlineStatus(rawStatus.string("status")!!, rawStatus.long("cached")!!)
}

fun getBPServer(username: String) : String? {
    val obj = DownloadObj.blockPartyServer(username)
    return if (obj.string("server").equals("NONE")) null else obj.string("server")
}