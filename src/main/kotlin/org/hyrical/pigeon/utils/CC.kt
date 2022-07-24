package org.hyrical.pigeon.utils

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextDecoration
import net.kyori.adventure.text.minimessage.MiniMessage

class CC {}


fun translate(string: String): Component {
    val mm = MiniMessage.miniMessage()

    return mm.deserialize(string)
}

fun translate(string: String, menu: Boolean): Component {
    val mm = MiniMessage.miniMessage()

    if (menu){
        return mm.deserialize(string).decoration(TextDecoration.ITALIC, false)
    } else {
        return mm.deserialize(string)
    }
}

fun translate(list: MutableList<String>): MutableList<Component> {
    val l: MutableList<Component> = mutableListOf()
    val mm = MiniMessage.miniMessage()

    for (s in list){
        l.add(mm.deserialize(s))
    }

    return l
}

fun translate(list: MutableList<String>, menu: Boolean): MutableList<Component> {
    val l: MutableList<Component> = mutableListOf()
    val mm = MiniMessage.miniMessage()

    for (s in list){
        if (menu){
            l.add(mm.deserialize(s).decoration(TextDecoration.ITALIC, false))
            continue
        }

        l.add(mm.deserialize(s))
    }

    return l
}