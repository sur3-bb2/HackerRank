package samples

import sun.jvm.hotspot.utilities.IntArray





//https://www.geeksforgeeks.org/minimum-possible-sum-of-array-elements-after-performing-the-given-operation-2/?ref=rp

/**
Input: N = 3, X = 2, arr[] = {1, -2, 3}
Output: 0.5
Explanation:
On selecting subarray {3} and replacing it with {1.5}, the array becomes {1, -2, 1.5}, which gives sum = 0.5


Input: N = 5, X = 5, arr[] = {5, 5, 5, 5, 5}
Output: 5
Explanation:
On selecting subarray {5, 5, 5, 5, 5} and replacing it with {1, 1, 1, 1, 1}, the sum of the array becomes 5.

**/


fun maxSubArray(input: Array<Int>, divisor: Int): Double {
    var maxSoFar = Double.MIN_VALUE
    var maxEndingHere = 0.0
    var sum = 0.0

    for (element in input) {
        maxEndingHere += element
        if (maxSoFar < maxEndingHere) maxSoFar = maxEndingHere

        if (maxEndingHere < 0) maxEndingHere = 0.0

        sum += element
    }


    return sum - maxSoFar + (maxSoFar / divisor)
}

fun main(args: Array<String>) {
    val input1 = arrayOf(10, 20, 30, 40, 50)

    println(maxSubArray(input1, 2))

    val input2 = arrayOf(5, 5, 5, 5, 5)

    println(maxSubArray(input2, 5))

    val input3 = arrayOf(1, -2, 3)

    println(maxSubArray(input3, 2))
}