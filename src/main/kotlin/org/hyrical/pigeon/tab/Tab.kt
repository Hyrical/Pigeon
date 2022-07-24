package org.hyrical.pigeon.tab

import net.minestom.server.entity.Player

interface Tab {

    fun getTabElement(player: Player): TabElement

}