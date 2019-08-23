package samples

import java.util.*

// Complete the hourglassSum function below.
fun hourglassSum(arr: Array<Array<Int>>): Int {
    val sums = mutableListOf<Int>()

    for(i in 0 until arr.size - 2) {
        for(j in 0 until arr.size - 2) {
            val top = arr[i].slice(j..j+2)
            val middle = arr[i+1][j+1]
            val bottom = arr[i+2].slice(j..j+2)

            sums.add(top.sum() + middle + bottom.sum())
        }
    }

    return sums.max()!!
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val arr = Array(6) { Array(6) { 0 } }

    for (i in 0 until 6) {
        arr[i] = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
    }

    val result = hourglassSum(arr)

    println(result)
}