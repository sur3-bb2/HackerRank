package samples

//https://www.hackerrank.com/challenges/compare-the-triplets/problem
fun compareTriplets(a: Array<Int>, b: Array<Int>): Array<Int> {
    var sameValue = 0

    val aWins = a.withIndex().map {
        if(it.value == b[it.index]) {
            sameValue++
            false
        } else it.value > b[it.index]
    }.count { it }

    return arrayOf(aWins, 3 - aWins - sameValue)
}

fun main() {
    compareTriplets(arrayOf(17, 28, 30), arrayOf(99, 16, 8)).forEach { print(it) }

    compareTriplets(arrayOf(5,6,7), arrayOf(3,6,10)).forEach { print(it) }
}