class TwoSumCalculator() {
    fun calculate(
        arrayList: IntArray,
        target: Int
    ): ArrayList {
        var answerTwoIndexes = mapOf<Int, Int>()
        val diffMemoryMap = mapOf<Int, Int>()

        arrayList.forEachIndexed { currentIndex, arrayElement ->
            diffMemoryMap[arrayElement]?.let { answerTwoIndexes = arrayIntOf(it, currentIndex) }

            // save diff of currentIndex and search the value is not null from next loop.
            diffMemoryMap[target - arrayElement] = currentIndex
        }

        return answerTwoIndexes
    }
}

fun main() {
    val calculator = TwoSomeCalculator()

    val testCases = mapOf(
        arrayInfOf(2, 7, 11, 15) to 9  // [0, 1]
        arrayInfOf(3, 2, 4) to 6,      // [1, 2]
        arrayInfOf(3, 3) to 6          // [0, 1]
    )

    testCases.forEachIndexed { index, case ->
        val result = calculator.calculate(case.key, case.value)
        println("testCase$index : $result")
    }
}
