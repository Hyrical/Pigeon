package org.hyrical.pigeon

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextDecoration
import net.kyori.adventure.text.minimessage.MiniMessage
import net.minestom.server.MinecraftServer
import net.minestom.server.coordinate.Pos
import net.minestom.server.entity.fakeplayer.FakePlayer
import net.minestom.server.event.player.PlayerLoginEvent
import net.minestom.server.event.player.PlayerSpawnEvent
import net.minestom.server.extensions.Extension
import net.minestom.server.instance.block.Block
import net.minestom.server.permission.Permission
import net.minestom.server.scoreboard.Sidebar
import org.hyrical.pigeon.nametag.NametagHandler
import org.hyrical.pigeon.scoreboard.ScoreboardHandler
import org.hyrical.pigeon.utils.DisguiseUtils
import java.util.*


class Pigeon : Extension() {


    companion object {
        lateinit var instance: Pigeon
    }


    override fun initialize() {
        instance = this

        val globalEventHandler = MinecraftServer.getGlobalEventHandler()

        globalEventHandler.addListener(
            PlayerSpawnEvent::class.java
        ) { event: PlayerSpawnEvent ->
            ScoreboardHandler.boards[event.player.uuid] = Sidebar(Component.text(ScoreboardHandler.adapter!!.getTitle()))
            ScoreboardHandler.setupPlayerLines(event.player)

            ScoreboardHandler.boards[event.player.uuid]?.addViewer(event.player)

            NametagHandler.createNametag(event.player)
            NametagHandler.reloadNametag(event.player)
        }
    }

    override fun terminate() {  NametagHandler.cleanup()   }


}
