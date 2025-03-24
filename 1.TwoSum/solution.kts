//class TwoSumCalculator() {
//    fun calculate(nums: IntArray, target: Int): IntArray {
//        val diffMap = mutableMapOf<Int, Int>()
//        nums.forEachIndexed { index, int ->
//            diffMap[int]?.let { return intArrayOf(it, index) }
//            diffMap[target - int] = index
//        }
//        return intArrayOf()
//    }
//}
//
//fun main() {
//    val testCases = listOf(
//        intArrayOf(2, 7, 11, 15) to 9,     // [0,1]
//        intArrayOf(3, 2, 4) to 6,          // [1,2]
//        intArrayOf(3, 3) to 6              // [0,1]
//    )
//
//    val calculator = TwoSumCalculator()
//
//    testCases.forEach { (nums, target) ->
//        val result = calculator.calculate(nums, target)
//        println("Input: ${nums.joinToString()}, Target: $target => Output: ${result.joinToString()}")
//    }
//}
//
//main()

class TwoSumCalculator2() {
    fun calculate(
        arrayList: IntArray,
        target: Int
    ): IntArray {
        var answerTwoIndexes = mutableMapOf<Int, Int>()
        val diffMemoryMap = mutableMapOf<Int, Int>()

        arrayList.forEachIndexed { currentIndex, arrayElement ->
            diffMemoryMap[arrayElement]?.let { answerTwoIndexes = intArrayOf(it, currentIndex) }

            // save diff of currentIndex and search the value is not null from next loop.
            diffMemoryMap[target - arrayElement] = currentIndex
        }

        return answerTwoIndexes
    }
}

fun main2() {
    val calculator = TwoSomeCalculator()

    val testCases = mapOf(
        intArrayOf(2, 7, 11, 15) to 9, // [0, 1]
        intArrayOf(3, 2, 4) to 6,      // [1, 2]
        intArrayOf(3, 3) to 6          // [0, 1]
    )

    testCases.forEachIndexed { index, (arrayList, target) ->
        val result = calculator.calculate(arrayList, target)
        println("testCase$index : arrayList: ${arrayList.joinToStrings()}, target: $target, output -> $result")
    }
}

main2()
