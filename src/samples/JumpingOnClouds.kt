package samples

import java.util.*


// Complete the jumpingOnClouds function below.
fun jumpingOnClouds(c: Array<Int>): Int {
    var i = 0
    var steps = 0

    while(i < c.size - 1) {
        if(i + 2 < c.size && c[i + 2] == 0) {
            steps++
            i += 2
        } else if(i + 1 < c.size && c[i + 1] == 0) {
            steps++
            i += 1
        }
    }

    return steps
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val c = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val result = jumpingOnClouds(c)

    println(result)
}