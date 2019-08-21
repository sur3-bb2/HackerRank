package samples

import java.util.*

// Complete the countingValleys function below.
fun countingValleys(n: Int, s: String): Int {
    var valleys = 0
    var steps = 0

    s.forEach {
        if(it == 'D') steps--
        else steps++

        if(steps == 0 && it == 'U') {
            valleys++
        }
    }

    return valleys
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val s = scan.nextLine()

    val result = countingValleys(n, s)

    println(result)
}