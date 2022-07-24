package org.hyrical.pigeon.command

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.minestom.server.command.builder.Command
import net.minestom.server.command.builder.arguments.ArgumentType
import net.minestom.server.entity.Player
import net.minestom.server.scoreboard.Team
import org.hyrical.pigeon.utils.DisguiseUtils

object DisguiseCommand : Command("disguise") {

    init {
        val disguise = ArgumentType.String("username")


        addSyntax({ sender, context ->
            val username: String = context.get(disguise)

            DisguiseUtils.disguise(sender as Player, username)
            sender.sendMessage(Component.text("You have disguised into $username."))
        }, disguise)

    }
}