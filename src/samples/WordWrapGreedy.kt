package samples

fun justify(input: String, length: Int) : String {
    if(input.isEmpty() || length <= 0) return input

    var count = 0
    var temp = StringBuilder()

    for(i in input.split(" ")) {
        if(count + i.length > length) {
            count = 0
            temp.append("\n")
        }

        temp.append("$i ")
        count += (i.length + 1)
    }

    return temp.toString()
}

fun main(args: Array<String>) {
    val para = "Design a word wrap micro service which provides functionality to take an input string and wraps it so that none of the lines are longer than the max length. The lines should not break any word in the middle."
    val maxWidth = 26

    print(justify(para, maxWidth))

    println()

    val para1 = "aaa bb cc ddddd"
    val maxWidth1 = 6

    print(justify(para1, maxWidth1))
}