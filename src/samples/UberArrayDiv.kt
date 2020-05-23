package samples

/*
https://medium.com/javascript-in-plain-english/these-coding-problems-were-asked-by-uber-4cf366d9ef9b


 */

fun badSolution(input: Array<Int>): List<Int> {
    val output = mutableListOf<Int>()

    input.forEachIndexed { index, _ ->
        var temp = 1

        input.forEachIndexed { inner, i ->
            if(inner != index) temp *= i
        }

        output.add(temp)
    }

    return output
}

fun goodSolution(input: Array<Int>): List<Int> {
    val leftMap = mutableMapOf<Int, Int>()
    val rightMap = mutableMapOf<Int, Int>()
    val result = mutableListOf<Int>()

    leftMap[-1] = 1
    input.forEachIndexed { index, i ->
        leftMap[index] = i * leftMap[index - 1]!!
    }

    rightMap[input.size] = 1

    for(i in input.size - 1 downTo 0) {
        rightMap[i] = input[i] * rightMap[i + 1]!!
    }

    input.forEachIndexed { index, _ ->
        result.add(leftMap[index - 1]!! * rightMap[index + 1]!!)
    }

    return result
}

fun main(args: Array<String>) {
    val input1 = arrayOf(3,2,1)
    val input2 = arrayOf(1,2,3,4,5)

    badSolution(input1).forEach {
        print("$it, ")
    }

    println()

    badSolution(input2).forEach {
        print("$it, ")
    }

    goodSolution(input1).forEach {
        print("$it, ")
    }

    println()

    goodSolution(input2).forEach {
        print("$it, ")
    }

    val i = arrayOf(3, 4, -1, 1)

    val n = Array<Int>(i.max()!! + 1) { it }

    println(n.filter { !i.contains(it + 1) }.first() + 1)

    val i1 = arrayOf(1, 2, 0)

    val n1 = Array<Int>(i1.max()!! + 1) { it }

    println(n1.filter { !i1.contains(it + 1) }.first() + 1)

}