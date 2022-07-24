package org.hyrical.pigeon.scoreboard

import org.hyrical.pigeon.Pigeon
import net.minestom.server.MinecraftServer
import net.minestom.server.scoreboard.Team
import java.lang.Exception

class ScoreboardThread : Thread("Pigeon - Scoreboard Thread") {

    override fun run(){
        while (true){

            try {
                tick()
                sleep(ScoreboardHandler.update * 50)
            } catch (e: Exception){
                e.printStackTrace()
            }

        }
    }

    private fun tick(){
        for (player in MinecraftServer.getConnectionManager().onlinePlayers){
            try {
                if (ScoreboardHandler.boards[player.uuid] == null || ScoreboardHandler.adapter == null) continue

                for (line in ScoreboardHandler.adapter!!.getLines(player)){
                    ScoreboardHandler.boards[player.uuid]
                        ?.updateLineContent("score_${line.key}_${player.uuid}", line.value)
                } // technically, this should work as we're just updating the line
            } catch (e: Exception){
                e.printStackTrace()
                throw Exception("An unknown error has occurred while updating ${player.name}'s scoreboard.")
            }
        }
    }

}