package org.hyrical.pigeon.tab

import net.kyori.adventure.text.Component
import net.minestom.server.entity.Player
import net.minestom.server.entity.fakeplayer.FakePlayer
import java.util.*


class TabAdapter {

    val fakePlayers: MutableMap<UUID, Array<FakePlayer>> = mutableMapOf()
    val initializedPlayers: MutableList<UUID> = mutableListOf()

    /**
     * Setup the profiles of the tab adapter
     */
    fun setupProfiles(player: Player?): TabAdapter {
        for (y in 0..19) {
            for (x in 0..3) {
                val index = y * 4 + x
                val text = "§0§$x" + if (y > 9) "§" + y.toString().toCharArray()[0] + "§" + y.toString()
                    .toCharArray()[1] else "§0§" + y.toString().toCharArray()[0]
                createProfiles(index, text, player)
            }
        }
        return this
    }

    /**
     * Handle an element being send to a player
     *
     * @param player  the player
     * @param element the element to send
     */
    /*
    fun handleElement(player: Player?, element: TabElement): TabAdapter {
        val rows = getMaxElements(player) / 20
        for (y in 0..19) {
            for (x in 0 until rows) {
                val (_, _, text, ping, skinData) = element.getEntry(x, y)
                val index = y * rows + x
                sendEntryData(player, index, ping, text)

                updateSkin(skinData, index, player)

            }
        }
        return this
    }

     */


    /**
     * Update the skin on the tablist for a player
     *
     * @param skinData the data of the new skin
     * @param index    the index of the profile
     * @param player   the player to update the skin for
     */
     fun updateSkin(skinData: Array<String>, index: Int, player: Player){

     }

    /**
     * Check if the player should be able to see the fourth row
     *
     * @param player the player
     * @return whether they should be able to see the fourth row
     */
     fun getMaxElements(player: Player?): Int {
         return 80
     }

    /**
     * Create a new game profile
     *
     * @param index  the index of the profile
     * @param text   the text to display
     * @param player the player to make the profiles for
     */
     fun createProfiles(index: Int, text: String?, player: Player?) {

     }

    /**
     * Send the header and footer to a player
     *
     * @param player the player to send the header and footer to
     * @param header the header to send
     * @param footer the footer to send
     * @return the current adapter instance
     */
     fun sendHeaderFooter(player: Player, header: Component, footer: Component): TabAdapter? {
         player.sendPlayerListFooter(footer)
         player.sendPlayerListHeader(header)

         return this
     }

    /**
     * Send an entry's data to a player
     *
     * @param player the player
     * @param axis   the axis of the entry
     * @param ping   the ping to display on the entry's position
     * @param text   the text to display on the entry's position
     * @return the current adapter instance
     */
    fun sendEntryData(player: Player, axis: Int, ping: Int, text: String): TabAdapter? {
        return this
    }

    /**
     * Add fake players to the player's tablist
     *
     * @param player the player to send the fake players to
     * @return the current adapter instance
     */
    fun addFakePlayers(player: Player?): TabAdapter? {
        return this
    }
    /*

    /**
     * Hide all real players from the tab
     *
     * @param player the player
     * @return the current adapter instance
     */
     fun hideRealPlayers(player: Player?): TabAdapter? {

     }

    /**
     * Hide a real player from the tab
     *
     * @param player the player to hide the player from
     * @param target the player to hide
     * @return the current adapter instance
     */
     fun hidePlayer(player: Player?, target: Player?): TabAdapter? {

     }

    /**
     * Show all real players on the tab
     *
     * @param player the player
     * @return the current adapter instance
     */
     fun showRealPlayers(player: Player?): TabAdapter? {

     }

    /**
     * Show a real player to a player
     *
     * @param player the player
     * @param target the player to show to the other player
     * @return the current adapter instance
     */
    fun showPlayer(player: Player?, target: Player?): TabAdapter? {

    }

     */
}