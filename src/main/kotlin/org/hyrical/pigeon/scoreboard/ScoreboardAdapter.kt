package org.hyrical.pigeon.scoreboard

import net.kyori.adventure.text.Component
import net.minestom.server.entity.Player

interface ScoreboardAdapter {

    fun getTitle(): String


    fun getLines(player: Player): MutableMap<Int, Component>

}