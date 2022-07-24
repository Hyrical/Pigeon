package org.hyrical.pigeon.menu.preset

import net.minestom.server.entity.Player
import net.minestom.server.inventory.click.ClickType
import net.minestom.server.inventory.condition.InventoryConditionResult
import net.minestom.server.item.ItemStack
import net.minestom.server.item.Material
import org.hyrical.pigeon.menu.button.Button
import org.hyrical.pigeon.utils.Callback

class BooleanButton(val confirm: Boolean, val callback: Callback<Boolean>) : Button() {

    override fun getName(): String {
        return if (confirm) "<green>Confirm</green>" else "<red>Cancel</green>"
    }

    override fun getDescription(): MutableList<String> {
        return mutableListOf()
    }

    override fun getItem(): ItemStack {
        return if (confirm) ItemStack.of(Material.GREEN_WOOL) else
            ItemStack.of(Material.RED_WOOL)
    }

    override fun clicked(player: Player, slot: Int, clickType: ClickType, result: InventoryConditionResult) {
        player.closeInventory()
        callback.callback(confirm)
    }
}