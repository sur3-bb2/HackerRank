package samples

// https://www.geeksforgeeks.org/find-subarray-with-given-sum-in-array-of-integers/?ref=lbp

fun main(args: Array<String>) {
    val arr = intArrayOf(10, 2, -2, -20, 10)
    val sum = -10

    findArr(arr, sum)

    val arr1 = intArrayOf(1, 4, 20, 3, 10, 5)
    val sum1 = 33

    findArr(arr1, sum1)
}

private fun findArr(arr: IntArray, sum: Int) {
    var maps = mutableMapOf<Int, Int>()

    var temp = 0

    for (i in 0..arr.size-1) {
        temp += arr[i]

        if (temp == sum) {
            println("index from 0 to $i")

            return
        }

        if(maps.containsKey(temp - sum)) {
            println("index from ${maps[temp-sum]!!.inc()} to $i")
        }

        maps[temp] = i
    }
}