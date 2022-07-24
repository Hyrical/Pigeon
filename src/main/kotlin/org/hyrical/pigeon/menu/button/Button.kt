package org.hyrical.pigeon.menu.button

import net.kyori.adventure.text.Component
import net.minestom.server.entity.Player
import net.minestom.server.event.inventory.InventoryClickEvent
import net.minestom.server.inventory.click.ClickType
import net.minestom.server.inventory.condition.InventoryConditionResult
import net.minestom.server.item.ItemStack
import java.util.function.Consumer

abstract class Button{

    abstract fun getName(): String

    abstract fun getDescription(): MutableList<String>

    abstract fun getItem(): ItemStack

    open fun clicked(player: Player, slot: Int, clickType: ClickType, result: InventoryConditionResult) {}

}