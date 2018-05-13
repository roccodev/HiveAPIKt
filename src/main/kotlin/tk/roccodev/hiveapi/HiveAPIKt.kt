package tk.roccodev.hiveapi

import tk.roccodev.hiveapi.game.Game
import tk.roccodev.hiveapi.player.HivePlayer
import tk.roccodev.hiveapi.player.stats.BED
import tk.roccodev.hiveapi.player.stats.DR
import tk.roccodev.hiveapi.rank.Ranks
import tk.roccodev.hiveapi.server.Server
import tk.roccodev.hiveapi.util.dateFromHiveSeconds

fun main(args: Array<String>) {

    println(BED("RoccoDev").lastLogin?.let { dateFromHiveSeconds(it) })
    println(Ranks().getRank("OWNER").human)
    println(HivePlayer("RoccoDev").trophies[4].game)
    println(HivePlayer("RoccoDev").unlockedAchievements.size)
    println(Server().achievements[0].secret)
    println(Game("BED").uniquePlayers)
    println(Game("BED").maps.getMapByCommonName("Hell").worldName)
    println(DR("RoccoDev").mapRecords["DR_Ice"])


}