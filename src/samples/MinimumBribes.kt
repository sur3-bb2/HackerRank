package samples

import java.util.*
import kotlin.math.max
import kotlin.math.min

// Complete the minimumBribes function below.
fun minimumBribes1(q: Array<Int>) {
    var numOfBribes = 0

    for(i in q.size - 1 downTo 0) {
        if(q[i] < q[i-1]) {
            if(q[i-1].minus(q[i]) <= 2) numOfBribes += (q[i - 1].minus(q[i]))
            else {
                println("Too chaotic")
                return
            }
        }

        /*if(q[q.size - i] > q[q.size - i + 1]) {
            if(q[q.size - i].minus(q[q.size - i + 1]) > 2) {
                chaotic = true
                break
            }
            else numOfBribes++
        }*/
    }

    println(numOfBribes)
}

fun minimumBribes(q: Array<Int>) {
    var numOfBribes = 0

    for(i in q.size - 1 downTo 0) {
        /**
         * 1 2 3 4 5 6 7 8
         * let's say, wat is possible at index 2(3,4,5 but not 6, so item - index + 1
         */
        if(q[i]-(i+1) > 2)
        {
            println("Too chaotic")
            return
        }
        /**
         * 1 2 3 4 5 6 7 8
         * 1 2 5 3 7 8 6 4
         * It's impossible for any number greater than q[i] reach beyond q[i] - 2 as only allow two bribes
         *
         * for last item 4, which was in index 3, maximum no of elements we need to check is from index 2....
         */
        for (j in max(0, q[i] - 2) until i)
            if (q[j] > q[i]) numOfBribes++
    }

    println(numOfBribes)
}

fun minimumBribesx(q: Array<Int>) {
    var numOfBribes = 0
    var lowest = q.last()
    var temp = 0

    for(i in q.size - 1 downTo 0) {
        if(q[i] < lowest) {
            lowest = q[i]

            continue
        }

        for (j in i + 1 until q.size) {
            lowest = min(q[j], lowest)

            if (q[i] > q[j]) temp++

            if(temp > 2) {
                println("Too chaotic")

                return
            }
        }

        numOfBribes += temp
        temp = 0
    }

    println(numOfBribes)
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