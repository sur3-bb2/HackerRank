package samples

const val Infinity = Integer.MAX_VALUE

infix fun Int.downUntil(to: Int): IntProgression {
    if (to >= Int.MAX_VALUE) return IntRange.EMPTY
    return this downTo (to + 1)
}

fun createBadnessMatrix(words: List<String>, maxWidth: Int): Array<IntArray> {
    val size = words.size

    val spacesMatrix = Array(size) {
        IntArray(size)
    }

    // aaa, bb, cc, ddddd
    // [0 aaa] -> [6-3 max(6) - currentValue(aaa) , 6(max)-3(prev aaa) - 2(bb) -1(space)
    // or prevIndex(3) - currentWordLength bb (2) - space (1), ......
    //
    words.forEachIndexed { index, s ->
        spacesMatrix[index][index] = maxWidth - s.length

        for(inner in index+1 until size) {
            spacesMatrix[index][inner] = spacesMatrix[index][inner - 1] - words[inner].length - 1
        }
    }

    val badness = Array(size) {
        IntArray(size)
    }

    // Cube the values, Cubes is better indicator for badness
    // Cube is latex rule
    // 1) There are 3 lines. One line has 3 extra spaces and all other lines have 0 extra spaces.
    // Total extra spaces = 3 + 0 + 0 = 3. Total cost = 3*3*3 + 0*0*0 + 0*0*0 = 27.
    //
    // 2) There are 3 lines. Each of the 3 lines has one extra space.
    // Total extra spaces = 1 + 1 + 1 = 3. Total cost = 1*1*1 + 1*1*1 + 1*1*1 = 3.
    //badness = infinity if can't fit into totalWidth or Cube of (pageWidth - totalWidth)

    spacesMatrix.forEachIndexed { outer, ints ->
        ints.forEachIndexed { inner, i ->
            if(i < 0) badness[outer][inner] = Infinity
            else badness[outer][inner] = i * i
        }
    }

    return badness
}

fun solveWrap(input: String, maxLength: Int): String {
    val list = input.split(" ")
    val size = list.size
    val badness = createBadnessMatrix(list, maxLength)

    val minBadness = IntArray(size)
    val result = IntArray(size)

    for(i in size - 1 downTo 0) {
        minBadness[i] = badness[i][size - 1]
        result[i] = size

        for(j in size - 1 downUntil i) {
            if(badness[i][j - 1] != Infinity) {
                if(minBadness[i] > badness[i][j - 1] + minBadness[j]) {
                    minBadness[i] = badness[i][j - 1] + minBadness[j]
                    result[i] = j
                }
            }
        }
    }

    var start = 0
    var end = 0
    val output = StringBuilder()

    do {
        end = result[start]
        for (k in start until end) {
            output.append("${list[k]} ")
        }
        output.append("\n")
        start = end
    } while (end < list.size)

    return output.toString()
}


fun main(args: Array<String>) {
    val input1 = "suresh bab likes to code"
    val input2 = "Design a word wrap micro service which provides functionality to take an input string and wraps it so that none of the lines are longer than the max length. The lines should not break any word in the middle."
    val input3 = "aaa bb cc ddddd"

    println(solveWrap(input1, 10))
    println(solveWrap(input2, 23))
    println(solveWrap(input3, 6))
}