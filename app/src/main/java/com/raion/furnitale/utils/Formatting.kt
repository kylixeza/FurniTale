package com.raion.furnitale.utils

object Formatting {
    fun rupiahCurrencyFormatting(price: Int?): String {
        var result = ""
        if (price != null) {
            val separated = price.toString().toCharArray()
            var index = separated.size - 1
            var count = 1

            do {
                result = String.format("${separated[index]}$result")
                if (count % 3 == 0 && index != 0)
                    result = String.format(".$result")
                index--
                count++
            } while (index != -1)
        }
        return result
    }
}