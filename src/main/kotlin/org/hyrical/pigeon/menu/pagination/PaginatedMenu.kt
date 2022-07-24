package org.hyrical.pigeon.menu.pagination

import net.minestom.server.entity.Player
import net.minestom.server.inventory.InventoryType
import org.hyrical.pigeon.menu.Menu
import org.hyrical.pigeon.menu.button.Button
import java.lang.Math.ceil

abstract class PaginatedMenu : Menu() {

    var page: Int = 1

    abstract fun getPaginatedTitle(): String

    override fun getTitle(): String {
        return getPaginatedTitle() + " $page "
    }

    internal fun getPages(player: Player): Int {
        val buttonAmount = getAllPageButtons(player).size

        return if (buttonAmount == 0) {
            1
        } else {
            kotlin.math.ceil(buttonAmount / getMaxItemsPerPage(player).toDouble()).toInt()
        }
    }

    override fun getButtons(player: Player): MutableMap<Int, Button> {
        val buttons: MutableMap<Int, Button> = mutableMapOf()


        val pageButtonSlots = getPageButtonSlots()
        if (pageButtonSlots != null) {
            /*
            buttons[pageButtonSlots.first] = PageButton(-1, this)
            buttons[pageButtonSlots.second] = PageButton(1, this)

             */
        }

        return buttons

    }

    abstract fun getAllPageButtons(player: Player): MutableMap<Int, Button>

    open fun getMaxItemsPerPage(player: Player): Int {
        return 18
    }

    open fun getPageButtonSlots(): Pair<Int, Int>? {
        return Pair(0, 8)
    }
}