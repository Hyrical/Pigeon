package org.hyrical.pigeon.scoreboard

import net.kyori.adventure.text.Component
import net.minestom.server.MinecraftServer
import net.minestom.server.entity.Player
import net.minestom.server.scoreboard.Sidebar
import java.util.*
import java.util.concurrent.ConcurrentHashMap

object ScoreboardHandler {

    var adapter: ScoreboardAdapter? = null

    var boards: MutableMap<UUID, Sidebar> = mutableMapOf()
    var update: Long = 2L

    fun init(update: Long, adapter: ScoreboardAdapter){
        this.adapter = adapter

        ScoreboardHandler.update = update
    }


    fun setupPlayerLines(player: Player){

        for (line in adapter!!.getLines(player)){
            boards[player.uuid]
                ?.createLine(Sidebar.ScoreboardLine(
                    "score_${line.key}_${player.uuid}",
                    line.value,
                    line.key
                ))
        }

        ScoreboardThread().start()
    }
}