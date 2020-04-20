package samples

fun isSubString(pattern: String, input: String) : Int {
    for(i in 0..input.length.minus(pattern.length)) {
        if(input[i] == pattern[0] && i + pattern.length < input.length) {
            if(input.substring(i, i + pattern.length) == pattern) return i
        }
    }

    return -1
}

private fun test1(pattern: String, input: String) {
    val subStringIndex = isSubString(pattern, input)

    when(subStringIndex) {
        -1 -> println("not present")
        else -> println("index starts from $subStringIndex")
    }
}

fun main(args: Array<String>) {
    val pattern1 = "forever"
    val input1 = "forgeeksforforevergeeks"

    val pattern2 = "for"
    val input2 = "geeksforgeeks"

    test1(pattern1, input1)
    test1(pattern2, input2)
}