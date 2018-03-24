package tk.roccodev.hiveapi

import tk.roccodev.hiveapi.game.Game
import tk.roccodev.hiveapi.player.HivePlayer
import tk.roccodev.hiveapi.player.stats.BED
import tk.roccodev.hiveapi.rank.Ranks
import tk.roccodev.hiveapi.server.Server

fun main(args: Array<String>) {

    println(BED("RoccoDev").kills)
    println(Ranks().getRank("OWNER").human)
    println(HivePlayer("RoccoDev").trophies[4].game)
    println(HivePlayer("RoccoDev").unlockedAchievements.size)
    println(Server().achievements[0].secret)
    println(Game("BED").uniquePlayers)


}