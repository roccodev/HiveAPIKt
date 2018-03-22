package tk.roccodev.hiveapi

import tk.roccodev.hiveapi.player.HivePlayer
import tk.roccodev.hiveapi.player.stats.BED
import tk.roccodev.hiveapi.rank.Ranks

fun main(args: Array<String>) {

    println(BED("RoccoDev").kills)
    println(Ranks().getRank("OWNER").human)
    println(HivePlayer("RoccoDev").rank.human)
    println(HivePlayer("RoccoDev").unlockedAchievements.size)



}