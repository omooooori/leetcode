enum class RomanNumeral(
    val symbol: String,
    val value: Int
) {
    I("I", 1),
    V("V", 5),
    X("X", 10),
    L("L", 50),
    C("C", 100),
    D("D", 500),
    M("M", 1000);

    companion object {
        private val symbolToValueMap = entries.associateBy { it.symbol }
        fun fromSymbol(symbol: String): RomanNumeral? = symbolToValueMap[symbol]
    }
}

class RomanNumeralConverter {
    fun romanToInt(roman: String): Int {
        var result = 0
        var i = 0

        while (i < roman.length) {
            val currentSymbol = roman[i].toString()
            val currentNumeral = RomanNumeral.fromSymbol(currentSymbol)
                ?: throw IllegalArgumentException("Invalid Roan numeric character: $currentSymbol")

            val nextNumeral = if (i + 1 < roman.length) {
                RomanNumeral.fromSymbol(roman[i + 1].toString())
            } else {
                null
            }

            if (nextNumeral != null && currentNumeral.value < nextNumeral.value) {
                // Subtractive notation (e.g., IV, IX)
                result += nextNumeral.value - currentNumeral.value
                i += 2
            } else {
                result += currentNumeral.value
                i ++
            }
        }

        return result
    }
}

fun main() {
    val converter = RomanNumeralConverter()

    println(converter.romanToInt("III"))      // 3
    println(converter.romanToInt("LVIII"))    // 58
    println(converter.romanToInt("MCMXCIV"))  // 1994
}

main()
