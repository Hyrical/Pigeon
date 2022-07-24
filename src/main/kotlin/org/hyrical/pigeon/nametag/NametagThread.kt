package org.hyrical.pigeon.nametag

import net.minestom.server.MinecraftServer

class NametagThread : Thread("Pigeon - Nametag Thread") {

    override fun start() {
        try {
            tick()
            sleep(10L * 50)
        } catch (e: Exception){
            e.printStackTrace()
        }
    }

    private fun tick(){
        for (player in MinecraftServer.getConnectionManager().onlinePlayers){
            NametagHandler.reloadNametag(player)
        }
    }
}