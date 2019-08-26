package samples

import java.util.*
import java.util.function.Function
import java.util.stream.Collectors
import java.util.stream.IntStream
import kotlin.math.abs

data class Lowest(val value: Int, val index: Int)

// Complete the minimumSwaps function below.
fun minimumSwapsExpensive(arr: Array<Int>): Int {
    var swaps = 0
    var index = 0
    var nextLeastNoInArray = 0

    while(index < arr.size - 1) {
        if(index > 0 && arr[index].minus(arr[index - 1]) == 1) {
            nextLeastNoInArray = arr[index++]
            continue
        }

        var highest = arr[index]
        var lowest = Lowest(highest, index)
        var forwardIndex = index + 1

        for(j in arr.size - 1 downTo index + 1) {
            if(arr[j] < lowest.value) {
                lowest = Lowest(arr[j], j)
                if(lowest.value - nextLeastNoInArray == 1) break
            }

            if(arr[forwardIndex] < lowest.value) {
                lowest = Lowest(arr[forwardIndex], forwardIndex)
                forwardIndex++
                if(abs(lowest.value - nextLeastNoInArray) == 1) break
            }
        }

        if(lowest.value != highest) {
            swaps++
            arr[lowest.index] = arr[index]
            arr[index] = lowest.value
            nextLeastNoInArray = lowest.value
        }

        index++
    }

    return swaps
}

// Complete the minimumSwaps function below.
fun minimumSwaps(arr: Array<Int>): Int {
    var swaps = 0
    //var s = arr.sortedArray()
    //var sortedArray = arr.associateBy( { it }, { arr.indexOf(it) }).toMutableMap()
    val sortedArray : MutableMap<Int, Int> = IntStream.range(0, arr.size).boxed()
        .collect(Collectors.toMap({ i -> arr[i] }, { i -> i }))


    for(i in 0 until arr.size) {
        if(arr[i] == i + 1) {
            continue
        }

        var indexToSwap = sortedArray.getValue(i + 1)


        sortedArray[arr[i]] = indexToSwap
        sortedArray[i + 1] = i

        var temp = arr[i]
        arr[i] = arr[indexToSwap]
        arr[indexToSwap] = temp

        swaps++
    }

    return swaps
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val res = minimumSwaps(arr)

    println(res)
}