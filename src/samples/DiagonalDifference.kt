package samples

import kotlin.math.abs

fun diagonalDifference(arr: Array<Array<Int>>): Int {
    var total = arr.size

    return abs(arr.withIndex().map {
        val row = arr[it.index]
        total--

        if (it.index == total) 0
        else row[it.index] - row[total]
    }.reduce { acc, i -> acc.plus(i) })

    //return 0
}

fun main() {
    val totalItems = readLine()!!.toInt()

    val matrix = Array(totalItems) { Array(totalItems) { 0 } }

    for(i in 0 until totalItems) {
        matrix[i] = readLine()!!.split(' ').map { it.toInt() }.toTypedArray()
    }

    val result = diagonalDifference(matrix)

    println(result)
}