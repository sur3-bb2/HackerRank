package samples

import kotlin.math.min

/**
 * https://leetcode.com/problems/trapping-rain-water/
 */

fun main() {
    val map = arrayOf(0,1,0,2,1,0,1,3,2,1,2,1)
    var last = map.size - 1

    var leftToRightArray = mutableListOf<Int>()
    var rightToLeftArray = mutableListOf<Int>()

    var waterLevel = 0

    var leftToRightHigh = map[0]
    var rightToLeftHigh = map.last()

    map.forEach { current ->
        if(current > leftToRightHigh) leftToRightHigh = current

        if(map[last] > rightToLeftHigh) rightToLeftHigh = map[last]

        last--

        leftToRightArray.add(leftToRightHigh)
        rightToLeftArray.add(rightToLeftHigh)
    }

    last = rightToLeftArray.size - 1

    map.forEachIndexed { index, i ->
        waterLevel += (min(leftToRightArray[index], rightToLeftArray[last - index]) - map[index])
    }

    println("Total water that can be trapped : $waterLevel")
}