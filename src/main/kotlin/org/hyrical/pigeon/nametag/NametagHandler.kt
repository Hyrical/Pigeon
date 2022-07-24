package org.hyrical.pigeon.nametag

import net.kyori.adventure.text.Component
import net.minestom.server.MinecraftServer
import net.minestom.server.entity.Player
import net.minestom.server.network.packet.server.play.TeamsPacket
import net.minestom.server.scoreboard.Team

object NametagHandler {

    var adapter: NametagAdapter? = null
    var update = 10L

    private var teamCreateIndex = 1

    fun init(adapter: NametagAdapter){
        this.adapter = adapter

        NametagThread().start()
    }

    fun cleanup(){
        for (team in MinecraftServer.getTeamManager().teams){
            MinecraftServer.getTeamManager().deleteTeam(team)
        }
    }

    fun createNametag(player: Player){
        if (adapter == null) return

        val team = MinecraftServer.getTeamManager()
            .createBuilder(teamCreateIndex.toString())
            .prefix(adapter!!.getNametag().prefix)
            .suffix(adapter!!.getNametag().suffix)
            .teamColor(adapter!!.getNametag().teamColor)
            .nameTagVisibility(TeamsPacket.NameTagVisibility.ALWAYS)
            .build()

        teamCreateIndex++

        team.addMember(player.username)
    }

    fun reloadNametag(player: Player){
        if (player.team == null) return

        player.team.prefix = adapter!!.getNametag().prefix
        player.team.suffix = adapter!!.getNametag().suffix
    }
}