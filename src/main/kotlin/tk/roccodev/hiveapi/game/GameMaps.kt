package tk.roccodev.hiveapi.game

import tk.roccodev.hiveapi.http.DownloadObj

class GameMaps(shortCode: String) {


    val maps : MutableList<GameMap> = mutableListOf()


    init{
        maps.addAll(DownloadObj.allMapData(shortCode))
    }

    fun getMapByEnumName(enumName: String) : GameMap {
        return maps.stream().filter { m -> m.enumName == enumName }.findAny().get()
    }

    fun getMapByCommonName(commonName: String) : GameMap {
        return maps.stream().filter { m -> m.mapName == commonName }.findAny().get()
    }





}



