package org.hyrical.pigeon.utils

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.minestom.server.entity.Player
import net.minestom.server.entity.PlayerSkin
import java.lang.NullPointerException

object DisguiseUtils {

    fun disguise(player: Player, disguise: String){
        try {
            player.displayName = Component.text(disguise)
            player.setUsernameField(disguise)

            player.skin = PlayerSkin.fromUsername(disguise)
        } catch (e: NullPointerException){
            player.sendMessage("${NamedTextColor.RED}The disguise $disguise was not found.")
        }
    }

}