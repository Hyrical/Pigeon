package org.hyrical.pigeon.tab

data class TabEntry(val column: Int,
                    val row: Int,
                    val text: String,
                    val ping: Int,
                    val skinData: Array<String>) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TabEntry

        if (column != other.column) return false
        if (row != other.row) return false
        if (text != other.text) return false
        if (!skinData.contentEquals(other.skinData)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = column
        result = 31 * result + row
        result = 31 * result + text.hashCode()
        result = 31 * result + skinData.contentHashCode()
        return result
    }
}