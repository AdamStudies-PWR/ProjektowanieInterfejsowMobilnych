package com.amazeum.kryptor3

import java.util.*

class Converter {
    val version = "07102020"
    private fun charToInt(symbol: Char): Int {
        val number = symbol.toInt()
        return if (number < conversionTables.charToInt.size) {
            conversionTables.charToInt[number]
        } else '?'.toInt()
    }

    private fun intToChar(number: Int): Char {
        var number = number
        if (number > 511) number -= 512
        if (number < 0) number += 512
        return if (number < conversionTables.intToChar.size) {
            conversionTables.intToChar[number].toChar()
        } else '?'
    }

    private fun shuffling(text: LinkedList<Int>, `var`: Int): LinkedList<Int> {
        var `var` = `var`
        val half = text.size / 2 + text.size % 2
        var choice: Int
        val result = LinkedList<Int>()
        val part1 = LinkedList<Int>()
        val part2 = LinkedList<Int>()
        if (`var` < 0) {
            choice = -`var` % 4
            choice = -1 * choice
            `var` = -1 * `var`
        } else choice = `var` % 4
        return when (choice) {
            -3 -> {
                var i = 0
                while (i < text.size) {
                    result.add(text[i] - i % (`var` / 2))
                    i++
                }
                result
            }
            -1 -> {
                var i = 0
                while (i < half) {
                    result.add(text[i])
                    if (half + i < text.size) result.add(text[half + i])
                    i++
                }
                result
            }
            1 -> {
                var i = 0
                while (i < text.size) {
                    if (i % 2 == 1) part2.add(text[i]) else part1.add(text[i])
                    i++
                }
                result.addAll(part1)
                result.addAll(part2)
                result
            }
            -2, 2 -> {
                var i = 1
                while (i <= text.size) {
                    result.add(text[text.size - i])
                    i++
                }
                result
            }
            3 -> {
                var i = 0
                while (i < text.size) {
                    result.add(text[i] + i % (`var` / 2))
                    i++
                }
                result
            }
            else -> text
        }
    }

    fun encryption(text: String): String {
        //--------------------------------------------------------------23102018
        var result = ""
        if (text.length < 1) return result
        var temp = LinkedList<Int>()
        val random = Random()
        val A1 = random.nextInt(27) + 44
        temp.add(A1)
        var A2 = random.nextInt(27) + 44
        while (A1 == A2) A2 = random.nextInt(27) + 44
        temp.add(A2)
        var A3 = random.nextInt(27) + 44
        while (A3 == A2 || A3 == A1) A3 = random.nextInt(27) + 44
        val A4 = random.nextInt(27) + 44
        var B1 = 1
        var B2 = 1
        var B3 = 1
        var B4 = 1
        if ((A1 + A2 + A3 + A4) % 3 == 1) {
            B2 *= -1
            B4 *= -1
        } else if ((A1 + A2 + A3 + A4) % 3 == 2) {
            B1 *= -1
            B2 *= -1
            B3 *= -1
            B4 *= -1
        }
        for (i in 0 until text.length) {
            if (i % 4 == 0) temp.add(charToInt(text[i]) + B1 * A1) else if (i % 4 == 1) temp.add(charToInt(text[i]) + B2 * A2) else if (i % 4 == 2) temp.add(charToInt(text[i]) + B3 * A3) else if (i % 4 == 3) temp.add(charToInt(text[i]) + B4 * A4)
        }
        temp.add(A3)
        temp = shuffling(temp, A4)
        temp.add(A4)
        for (`var` in temp) {
            result = result + intToChar(`var`)
        }
        return result
    }

    fun decryption(text: String): String {
        var result = ""
        if (text.length < 1) return result
        var temp = LinkedList<Int>()
        val A1: Int
        val A2: Int
        val A3: Int
        val A4 = charToInt(text[text.length - 1])
        var B1 = 1
        var B2 = 1
        var B3 = 1
        var B4 = 1
        for (i in 0 until text.length - 1) temp.add(charToInt(text[i]))
        temp = shuffling(temp, -A4)
        A1 = temp[0]
        temp.removeAt(0)
        A2 = temp[0]
        temp.removeAt(0)
        A3 = temp[temp.size - 1]
        temp.removeAt(temp.size - 1)
        if ((A1 + A2 + A3 + A4) % 3 == 1) {
            B2 *= -1
            B4 *= -1
        } else if ((A1 + A2 + A3 + A4) % 3 == 2) {
            B1 *= -1
            B2 *= -1
            B3 *= -1
            B4 *= -1
        }
        for (i in temp.indices) {
            if (i % 4 == 0) temp[i] = temp[i] - B1 * A1 else if (i % 4 == 1) temp[i] = temp[i] - B2 * A2 else if (i % 4 == 2) temp[i] = temp[i] - B3 * A3 else if (i % 4 == 3) temp[i] = temp[i] - B4 * A4
        }
        for (`var` in temp) result = result + intToChar(`var`)
        return result
    }

    companion object {
        var eureka = TreeSet<Int>()
        private val conversionTables = ConversionTables()
    }
}
