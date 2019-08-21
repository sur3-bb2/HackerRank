package samples

import java.util.*
import kotlin.math.floor

// Complete the repeatedString function below.
fun repeatedString(s: String, n: Long): Long {
    if(s.length >= n) return s.slice(0 until n.toInt()).count { it == 'a' }.toLong()

    val noOfAs = s.count { it == 'a' }.toLong()

    val totalAs = floor((n / s.length).toDouble()) * noOfAs

    val remaining = (n % s.length).toInt()

    if(remaining == 0) return totalAs.toLong()

    return (totalAs + s.slice(0 until remaining).count { it == 'a' }).toLong()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val n = scan.nextLine().trim().toLong()

    val result = repeatedString(s, n)

    println(result)
}
