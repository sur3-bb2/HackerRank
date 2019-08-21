package samples

import java.util.*
import kotlin.math.floor

data class Pairs(val pair: Double = 0.0, val count : Double = 0.0)

// Complete the sockMerchant function below.
fun sockMerchant(n: Int, ar: Array<Int>): Int {
    var socks = mutableMapOf<Int, Pairs>()

    ar.forEach {
        socks.putIfAbsent(it, Pairs())

        socks.computeIfPresent(it)
                { _, value -> Pairs(floor((value.count + 1) / 2), value.count + 1) }
    }

    return socks.map { it.value }.sumBy { it.pair.toInt() }
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val ar = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val result = sockMerchant(n, ar)

    println(result)
}