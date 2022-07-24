package org.hyrical.pigeon.menu

import net.minestom.server.MinecraftServer
import net.minestom.server.entity.Player
import net.minestom.server.inventory.Inventory
import net.minestom.server.inventory.InventoryType
import net.minestom.server.inventory.click.ClickType
import net.minestom.server.inventory.condition.InventoryConditionResult
import net.minestom.server.timer.Task
import net.minestom.server.timer.TaskSchedule
import org.hyrical.pigeon.menu.button.Button
import org.hyrical.pigeon.utils.translate
import java.util.*

abstract class Menu {

    private var inventory: Inventory? = null

    private val openedMenus: MutableMap<UUID, Menu> = mutableMapOf()
    private val tasks: MutableMap<UUID, Task> = mutableMapOf()

    abstract fun getTitle(): String

    abstract fun getInventoryType(): InventoryType

    abstract fun getButtons(player: Player): MutableMap<Int, Button>

    open fun createInventory(player: Player): Inventory {
        val title = getTitle()

        val buttons = getButtons(player)
        val inventoryType = getInventoryType()

        val inventory = Inventory(inventoryType, title)

        for (button in buttons){
            inventory.setItemStack(button.key, button.value.getItem()
                .withLore(translate(button.value.getDescription(), true)))

            inventory.addInventoryCondition { p: Player, slot: Int, clickType: ClickType, result: InventoryConditionResult ->
                button.value.clicked(p, slot, clickType, result)
            }
        }


        return inventory
    }


    open fun openMenu(player: Player){
        inventory = createInventory(player)

        player.openInventory(inventory!!)
        update(player)
    }

    private fun update(player: Player){
        if (tasks.containsKey(player.uuid)){
            tasks[player.uuid]?.cancel()

            tasks.remove(player.uuid)
        }

        val task: Task = MinecraftServer.getSchedulerManager().buildTask {
            if (player.isOnline){
                inventory!!.update(player)
            } else {
                if (tasks.containsKey(player.uuid)){
                    tasks[player.uuid]?.cancel()

                    tasks.remove(player.uuid)
                }

                openedMenus.remove(player.uuid)
            }
        }.repeat(TaskSchedule.tick(10)).schedule()

        tasks[player.uuid] = task
        openedMenus[player.uuid] = this
    }
}