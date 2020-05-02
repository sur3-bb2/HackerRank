package samples

/**
 * https://www.geeksforgeeks.org/find-the-number-occurring-odd-number-of-times/
 *
 * use XOR
 */

fun usingMap(input: Array<Int>) {
    val map = mutableMapOf<Int, Int>()

    input.forEach {
        map.putIfAbsent(it, 0)
        map.computeIfPresent(it) { _, value -> value + 1 }
    }

    map.forEach loop@{ (key, value) ->
        if(value % 2 == 1) {
            println(key)
            return@loop
        }
    }
}

fun usingXOR(input: Array<Int>) {
    var temp = 0

    input.forEach {
        temp = temp xor it
    }

    println(temp)
}

fun main(args: Array<String>) {
    val input = arrayOf(1, 2, 2, 2, 3, 3, 2, 1, 1)

    usingMap(input)

    usingXOR(input)
}