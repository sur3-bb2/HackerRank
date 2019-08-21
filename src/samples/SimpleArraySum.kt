package samples


fun sum2Numbs() {
    val (a, b) = readLine()!!.split(' ').map { it.toInt() }

    println(a.plus(b))
}

fun sum() = println(readLine()!!.split(' ').map { it.toInt() }.sum())



fun main() {
    //sum2Numbs()

    sum()
}
