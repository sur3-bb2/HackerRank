package samples

import java.util.*

// Complete the minimumBribes function below.
fun minimumBribes(q: Array<Int>) {
    var numOfBribes = 0
    var chaotic = false

    for(i in q.size - 1 downTo 0) {
        if(q[i] < q[i-1]) {
            if(q[i].minus(q[i-1]) <= 2) numOfBribes++
            else {
                chaotic = true
                break
            }
        }
    }

}

fun main() {
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toInt()

    for (tItr in 1..t) {
        val n = scan.nextLine().trim().toInt()

        val q = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

        minimumBribes(q)
    }
}