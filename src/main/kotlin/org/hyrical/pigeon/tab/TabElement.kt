package org.hyrical.pigeon.tab

import net.kyori.adventure.text.Component
import org.hyrical.pigeon.tab.skin.SkinType

class TabElement {

    private val entries: MutableList<TabEntry> = mutableListOf()

    val header: Component = Component.text("")
    val footer: Component = Component.text("")

    fun add(entry: TabEntry){
        entries.add(entry)
    }

    fun add(column: Int, row: Int, text: String){
        add(column, row, text, -1, SkinType.DARK_GRAY)
    }

    fun add(column: Int, row: Int, text: String, ping: Int, skinType: SkinType){
        entries.add(TabEntry(column, row, text, ping, skinType.data))
    }

    fun add(column: Int, row: Int, text: String, ping: Int, data: Array<String>){
        entries.add(TabEntry(column, row, text, ping, data))
    }

    fun getEntry(column: Int, row: Int): TabEntry {
        return entries.first {
            column == it.column
                    && row == it.row
        }
    }
}